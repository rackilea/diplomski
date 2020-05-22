for(int run = 0; run < 4; run++) {
    CompletableFuture<String> stage1 = new CompletableFuture<>();
    CompletableFuture<String> stage2 = stage1.exceptionally(t -> "alternative result");

    if(run > 1) stage2.cancel(false);

    if((run&1) == 0) stage1.complete("ordinary result");
    else stage1.completeExceptionally(new IllegalStateException("some failure"));

    stage1.whenComplete((v,t) ->
        System.out.println("stage1: "+(t!=null? "failure "+t: "value "+v)));
    stage2.whenComplete((v,t) ->
        System.out.println("stage2: "+(t!=null? "failure "+t: "value "+v)));
    System.out.println();
}