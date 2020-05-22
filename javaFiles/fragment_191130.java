List<MyResult> results =
    myInputList.stream()
               .map(myService::getResultFuture)
               .collect(Collectors.toList()).stream()
               .map(CompletableFuture::join)
               .collect(Collectors.toList());