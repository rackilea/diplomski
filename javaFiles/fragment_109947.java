CompletableFuture<String> stage1 = new CompletableFuture<>();
CompletableFuture<String> stage2 = stage1.thenCompose(s -> new CompletableFuture<>());
CompletableFuture<String> stage3 = stage2.exceptionally(t -> "alternative result");

stage1.complete("ordinary result"); // you can omit this line if you want
stage2.completeExceptionally(new IllegalStateException("some failure"));

stage3.whenComplete((v,t) ->
    System.out.println("stage3: "+(t!=null? "failure "+t: "value "+v)));