protected ListStore<ModelData> _createListStore(String url, String root, String fieldValue, String displayValue){
    ModelType mt = new ModelType();
    mt.setRoot(root);
    mt.addField(displayValue, fieldValue);
    RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, url);
    HttpProxy<String> proxy = new HttpProxy<String>(rb);
    JsonLoadResultReader<ListLoadResult<ModelData>> reader = new JsonLoadResultReader<ListLoadResult<ModelData>>(mt);
    final BaseListLoader<ListLoadResult<ModelData>> loader = new BaseListLoader<ListLoadResult<ModelData>>(proxy, reader);
    ListStore<ModelData> store = new ListStore<ModelData>(loader);
    return store;
}