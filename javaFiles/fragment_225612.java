public static Flux<StateMutator> createAndExecute(GithubPublicConfiguration config,
                                                  Function<GithubClient, Flux<StateMutator>> toExecute) {

    return Flux.using(
            () -> {
                logger.debug(Thread.currentThread().getName() + " : Created and started the client.");
                return new GithubClient(entityModelHandler, config.getAccessToken(), config.getConnectionCount());
            },
            client -> toExecute.apply(client),
            client -> {
                logger.debug(Thread.currentThread().getName() + " : Closing the client.");
                client.close();
            },
            false
    );
}