class Server extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        List<AbstractVerticle> verticles = searchForVerticlesWithMyAnnotation();
        verticles.forEach((V) = > router.add(V));
    }

}

@MyOwnJax(path = "/blaa")
public class TestService {
}

@interface MyOwnJax {
    String path();
}