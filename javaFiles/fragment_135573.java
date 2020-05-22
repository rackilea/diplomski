@Bean
public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("users", t -> t.path("/users")
                .uri("http://localhost:8080/users"))
            .route("userById", t -> t.path("/users/**")
                .filters(rw -> rw.rewritePath("/users/(?<segment>.*)", "/users/${segment}"))
                .uri("http://localhost:8080/users/"))
        .build();
    }