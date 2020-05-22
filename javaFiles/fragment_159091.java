FXMLLoader loader = new FXMLLoader(/* some location */);
loader.setControllerFactory(param -> {
    Object controller;
    try {
        controller = param.getConstructor().newInstance();
    } catch (ReflectiveOperationException ex) {
        throw new RuntimeException(ex);
    }
    if (controller instanceof Swappable) {
        ((Swappable) controller).setSwapper(swapper);
    }
    return controller;
}