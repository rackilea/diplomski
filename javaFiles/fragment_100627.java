protected <T extends AbstractModel> T getModelExample(Class<T> clazz) {
    // Get the swagger model instance including properties list with examples
    Map<String,Model> models = ModelConverters.getInstance().read(clazz);
    // Parse non-string example values into proper objects, and compile a map of properties representing an example object
    ExampleGenerator eg = new ExampleGenerator(models);
    Object resolved = eg.resolveModelToExample(clazz.getSimpleName(), null, new HashSet<String>());
    if (!(resolved instanceof Map<?,?>)) {
        // Model is not an instance of io.swagger.models.ModelImpl, and therefore no example can be resolved
        return null;
    }
    T result = clazz.newInstance();
    BeanUtils.populate(result, (Map<?,?>) resolved);
    return result;
}