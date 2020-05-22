import akka.actor.ActorSystem;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.IncomingConnection;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.*;
import akka.japi.function.Function;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.util.ByteString;
import scala.concurrent.duration.FiniteDuration;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

public class JavaHttpRequest {

    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create();
        final ActorMaterializer materializer = ActorMaterializer.create(system);

        Source<IncomingConnection, CompletionStage<ServerBinding>> serverSource =
                Http.get(system).bind(ConnectHttp.toHost("localhost", 8080));


        serverSource.to(Sink.foreach(connection -> {
            System.out.println("Accepted new connection from " + connection.remoteAddress());

            connection.handleWithSyncHandler(handleRequest(materializer), materializer);
        })).run(materializer);
    }

    private static Function<HttpRequest, HttpResponse> handleRequest(ActorMaterializer materializer) {
        return request -> {
            try {
                System.out.print(getString(materializer, request));
            } catch (Exception e) {
                e.printStackTrace();
            }

            return HttpResponse.create()
                    .withEntity(ContentTypes.TEXT_PLAIN_UTF8, "Success")
                    .withStatus(StatusCodes.OK);
        };
    }

    private static String getString(ActorMaterializer materializer, HttpRequest request) throws Exception {
        final CompletionStage<HttpEntity.Strict> strictEntity = request.entity()
                .toStrict(FiniteDuration.create(3, TimeUnit.SECONDS).toMillis(), materializer);

        final CompletionStage<String> stringStage = strictEntity
                .thenCompose(strict ->
                        strict.getDataBytes()
                                .runFold(ByteString.empty(), ByteString::concat, materializer)
                                .thenApply(ByteString::utf8String)
                );

        return stringStage.toCompletableFuture().get();
    }

}