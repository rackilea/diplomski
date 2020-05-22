CompletableFuture<Void> mt = CompletableFuture.supplyAsync(new Supplier<Void>() {
        @Override
        public Void get() {
            return MetadataLoginUtil.login();
        }
    })