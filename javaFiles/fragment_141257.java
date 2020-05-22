CompletableFuture<String> flag=new CompletableFuture<>();

CompletableFuture<String> ac = serviceCall(flag)
  .thenApply(w->x(w))
  .thenCompose(x -> serviceCall(flag))
  .thenCompose(x -> serviceCall(flag))
  .thenApply(z -> $(z));
ac.whenComplete((v,t)->flag.cancel(false));