private static Function<Shape, ModelBean> MODEL_BEAN_PROJECTION =
    new Function<Shape, ModelBean>() {
    final ModelBeanCreator binder = new ModelBeanCreator();

    @Override
    public ModelBean apply(Shape input) {
        return binder.createModelBean(input);
    }
};