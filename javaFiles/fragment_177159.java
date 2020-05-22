// each sumSquared() is submitted immediately to the common pool
CompletionStage<Double> sumList0 = CompletableFuture.supplyAsync(() -> sumSquared(list0));
CompletionStage<Double> sumList1 = CompletableFuture.supplyAsync(() -> sumSquared(list1));
CompletionStage<Double> sumList2 = CompletableFuture.supplyAsync(() -> sumSquared(list2));

// as soon as sumList1 and sumList2 have both complete, their product is computed
CompletionStage<Double> prodSumList1and2 = sumList1.thenCombine(sumList2, (a, b) -> a * b);
// as soon as their product is computed and sumList0 is finished, the final sum is computed
CompletionStage<Double> result = sumList0.thenCombine(prodSumList1and2, Double::sum);

System.out.println(result.toCompletableFuture().get());