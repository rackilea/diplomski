public interface Controller {
    void index(RoutingContext routingContext);
}
public class PostsController implements Controller {
    @Route(method="get", path = "/")
    public void index(RoutingContext routingContext){
        routingContext.response()
                .putHeader("content-type", "application/json; charset=utf-8")
                .end(Json.encodePrettily("{}"));
    }
}