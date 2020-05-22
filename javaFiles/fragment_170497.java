import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.runtime.server.EmbeddedServer;

@Controller("/demo")
public class DemoController {

    protected final String host;

    protected final int port;

    public DemoController(EmbeddedServer embeddedServer) {
        host = embeddedServer.getHost();
        port = embeddedServer.getPort();
    }

    @Get("/")
    public HttpStatus index() {
        return HttpStatus.OK;
    }
}