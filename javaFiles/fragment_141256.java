CompletableFuture<String> flag=new CompletableFuture<>();

CompletableFuture<String> ac = serviceCall()
  .thenCompose(x -> flag.isCancelled()? flag: serviceCall())
  .thenCompose(x -> flag.isCancelled()? flag: serviceCall());
ac.whenComplete((v,t)->flag.cancel(false));// don’t chain this call