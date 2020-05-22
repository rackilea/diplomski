private interface Op {
    void perform(ServiceApi serviceApi);
}

static void cache(Op op) {
    ServiceApi serviceApi = getService();
    if (serviceApi != null) {
        try {
            op.perform(serviceApi);
        } catch (BusinessException e) {
            log.error(e);
        }
    }

}

private void updateCache(List<CategoryObject> objectList) {
    cache(new Op() {
        @Override
        public void perform(ServiceApi serviceApi) {
            serviceApi.updateResources(objectList);
        }
    });
}

private void registerCache() {
    cache(new Op() {
        @Override
        public void perform(ServiceApi serviceApi) {
            serviceApi.registerCategory(CATEGORY_NAME);
        }
    });
}