public Mono<ServerResponse> hello(ServerRequest request) {
            Mono<String> requestMono = request.bodyToMono(String.class);
            Mono<String> mapped = requestMono.map(name -> "Hello " + name)
                .doOnSuccess(s -> System.out.println(s));
            return ServerResponse.ok().body(mapped, String.class);
        }