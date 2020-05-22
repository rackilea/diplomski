flux
    .flatMap(foo -> getBazRx(foo)
        .onErrorResume(t -> {
            log.error(t);
            return Mono.empty();
        }))