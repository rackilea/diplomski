webclient.get()
  .uri("/endpoint1")
  .retrieve()
  .bodyToFlux(MyBody.class)
  .retryWhen(errorCurrentAttempt -> errorCurrentAttempt
                .flatMap(currentError -> Mono.subscriberContext().map(ctx -> Tuples.of(currentError, ctx)))
                .flatMap(tp -> {
                    Context ctx = tp.getT2();
                    Throwable error = tp.getT1();
                    int maxAttempts = 3;
                    Integer rl = ctx.getOrDefault("retriesLeft", maxAttempts);
                    if (rl != null && rl > 0 && error == myExpectedError) {
                        // Call endpoint and retry
                        return webclient.get()
                                .uri("/endpoint2")
                                .retrieve()
                                .thenReturn(ctx.put("retriesLeft", rl - 1));
                    } else {
                        // Finish retries
                        return Mono.<Object>error(error);
                    }
                }));