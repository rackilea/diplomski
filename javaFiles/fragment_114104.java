public Single<ItemsResponse> getItems() {
    return verifySessionBeforeApi().flatMap(new Function<String, SingleSource
            <? extends ItemsResponse>>() {
        @Override
        public SingleSource<? extends ItemsResponse> apply(String sessionId)
                throws Exception {
            return makeFinalCall(new nextRequest(sessionId));
        }
    });
}