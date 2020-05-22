private void updateCache(List<CategoryObject> objectList) {
    cache(serviceApi -> serviceApi.updateResources(objectList));
}

private void registerCache() {
    cache(serviceApi -> serviceApi.registerCategory(CATEGORY_NAME));
}