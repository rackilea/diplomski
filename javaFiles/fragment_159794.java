public void testGetBlob() throws RequestException {
    TestData.getNewApplication().flatMap(testApplication -> {
// ...
        return entity.create();
    }).flatMap(entity -> 
        entity.setBlobProperty("text", "Hello world!".getBytes("UTF-8"))
            // 1. Flat map the setBlobProperty call and emit a Pair with the entity and result
            .flatMap(isSuccess -> Single.just(new Pair(entity, isSuccess)))
    )
            .flatMap(pair -> {
                if(pair.isSuccess()) {
                    // 2. entity is available here via pair.getEntity()
                    return Single.just(isSuccess);
                } else {
                    return Single.just(false);
                }
            }).subscribe(success -> {
// ...
    }
}