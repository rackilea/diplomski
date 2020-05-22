CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                DBRestorerWorker dbWork = new DBRestorerWorker();
                dbWork.run();
                return "someresult";
            };
        }).thenComposeAsync((Function<String, CompletionStage<Void>>) s -> {
            CompletableFuture<String> future = new CompletableFuture<>();
            try{
                //createOyster
                future.complete("oyster created");
            }catch (Exception ex) {
                future.completeExceptionally(ex);
            }
            return null;
        });