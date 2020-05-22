@Bean
RouterFunction<ServerResponse> routerFunction() {
    return route(GET("/"), req ->
            ServerResponse.temporaryRedirect(URI.create("/api/v1"))
                    .build());
}