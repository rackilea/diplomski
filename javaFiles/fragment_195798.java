import io.micronaut.http.*;
import io.micronaut.http.annotation.*;
import io.micronaut.http.server.util.HttpHostResolver;
import io.micronaut.web.router.RouteBuilder;

@Controller("/test")
public class TestController {
    private final HttpHostResolver httpHostResolver;
    private final RouteBuilder.UriNamingStrategy uriNamingStrategy;

    public TestController(
            HttpHostResolver httpHostResolver,
            RouteBuilder.UriNamingStrategy uriNamingStrategy
    ) {
        this.httpHostResolver = httpHostResolver;
        this.uriNamingStrategy = uriNamingStrategy;
    }

    @Get()
    @Produces(MediaType.TEXT_PLAIN)
    public String index(HttpRequest httpRequest) {
        return httpHostResolver.resolve(httpRequest) +
                uriNamingStrategy.resolveUri(TestController.class);
    }
}