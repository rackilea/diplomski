@Bean
public RouterFunction userRoutes() {
    return route(POST("/admin/users").and(accept(APPLICATION_JSON)),
                    request -> {
                        Mono<User> user = request.bodyToMono(User.class);
                            Mono<User> userMono = user.flatMap(userRepository::save);
                            return ServerResponse.status(HttpStatus.CREATED).body(userMono, User.class);
                    });
}