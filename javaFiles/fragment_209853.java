import java.util.ArrayList;
import java.util.List;

import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestOptions;
import io.vertx.ext.unit.TestSuite;
import io.vertx.ext.unit.report.ReportOptions;

public class HttpConcurrencyTest {

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();
        TestSuite suite = TestSuite.create("HttpConcurrencyTest");

        Integer requestCount = 100;
        Integer responseDelay = 200;
        Integer timeAllowed = 5000;
        String title = String.format("Sends %d HTTP requests with a response delay of %dms each within less than %dms.", requestCount,
                responseDelay, timeAllowed);

        suite.test(title, context -> {

            Async async = context.async();
            HttpServer server = vertx.createHttpServer();
            Long time = System.currentTimeMillis();

            server.requestHandler(request -> {
                vertx.setTimer(responseDelay, event -> {
                    request.response().end("ok");
                });
            });
            Integer port = 8181;
            server.listen(port, ar -> {
                context.assertTrue(ar.succeeded(), "Server not started");

                HttpClient client = vertx.createHttpClient();
                List<Future> futures = new ArrayList<>();
                for (int count = 0; count < requestCount; count++) {
                    Future future = Future.future();
                    futures.add(future);
                }
                CompositeFuture.all(futures).setHandler(result -> {
                    context.assertTrue(result.succeeded());
                    server.close();

                    Long duration = System.currentTimeMillis() - time;
                    context.assertTrue(duration < timeAllowed, duration + " >= " + timeAllowed);

                    async.complete();
                    System.exit(0);
                });

                futures.stream().forEach(future -> {
                    vertx.runOnContext(action -> {
                        client.getNow(port, "localhost", "/", result -> {
                            result.bodyHandler(body -> {
                                future.complete();
                            });
                        });
                    });
                });

            });
        });
        suite.run(new TestOptions().addReporter(new ReportOptions().setTo("console")));
    }
}