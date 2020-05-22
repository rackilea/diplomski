public List<Integer> afterFilteringList(List<Integer> initialList){
    Map<Integer,CompletableFuture<Boolean>> jobs = initialList.stream()
        .collect(Collectors.toMap(Function.identity(), this::makeNetworkCallAndCheck));
    return initialList.stream()
        .filter(element -> jobs.get(element).join())
        .collect(Collectors.toList());
}
public CompletableFuture<Boolean> makeNetworkCallAndCheck(Integer value){
   return CompletableFuture.supplyAsync(() -> resultOfNetWorkCall(value));
}