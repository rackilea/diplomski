crudResponse = listOfIterations.stream()
    .map(str -> CompletableFuture.supplyAsync(() -> {
        try {
            return async.hitCrud(str);
            }catch(RequestProcessingException e){
                log.error(e);
            }
            return function;
        }))
        .map(CompletableFuture::join)
        .collect(Collectors.toList());