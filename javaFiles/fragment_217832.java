public static <T> IModel<? extends List<T>> convertToListViewModel(List<T> objects) {

    final Class<? extends List> listClass = objects.getClass();

    // NOTE: you will need to implement the toLoadableDetachableModels method
    List<IModel<T>> asModels = toLoadableDetachableModels(objects);

    return new LoadableDetachableModel<List<T>>() {
        @Override
        protected List<T> load() {
            List<T> results = ClassUtils.newInstance(listClass);
            for(IModel<T> model : asModels) {
                results.add(model.getObject());
            }
            return results;
        }
    };
}