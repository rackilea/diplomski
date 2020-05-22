return Mono.fromCallable(this::trigger)
           .flatMap(s -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .syncBody(s))
           .onErrorResume(MinimalExampleException.class,
                        e -> ServerResponse.notFound().build());