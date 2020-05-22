import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class FileRepo extends AbstractVerticle {
    @Override
    public void start(Future<Void> fut) {
        Router router = Router.router(vertx);
        router.route("/upload").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response.putHeader("content-type", "text/plain");
            response.end("Hello world!");
        });
        System.out.println("Starting server!");
        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8080, result -> {
                    if (result.succeeded()) {
                        System.out.println("Server started!");
                        fut.complete();
                    } else {
                        System.out.println("Server start failed!");
                        fut.fail(result.cause());
                    }
                });
    }
}