loader.setControllerFactory(clazz -> {
    Object controller;
    try {
        controller = clazz.getConstructor().newInstance();
    } catch (ReflectiveOperationException ex) {
        throw new RuntimeException(ex);
    }
    if (controller instanceof BaseController) {
        ((BaseController) controller).setMainApp(this);
    }
    return controller;
});