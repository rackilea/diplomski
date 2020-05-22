public Future<Collection<Integer>> ensureFuture(Object value,
                                                     FutureFactory<Collection<Integer>> ff){
        if(chachedFutures.containsKey(value))
            return chachedFutures.get(value);
        Future<Collection<Integer>> ftr = ff.create();
        chachedFutures.put(value, ftr);
        return ftr;
    }

    public Future<Collection<Integer>> remove(Object value){
        return chachedFutures.remove(value);
    }