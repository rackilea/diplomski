@Configuration
public class RoutesConfig {
    @Bean
    public RouterFunction helloRoutesV1() {
        return RouterFunctions.route(RequestPredicates.path("/v1/hello-world"),
                request -> ok().body(fromObject("Hello World v1!")));
    }

    @Bean
    public RouterFunction helloRoutesV2() {
        return RouterFunctions.route(RequestPredicates.path("/v2/hello-world"),
                request -> ok().body(fromObject("Hello World v2!!!")));
    }
}