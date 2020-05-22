FXMLLoader loader = new FXMLLoader(/* some location */);
loader.setControllerFactory(param -> {
    Object controller;
    try {
        if (Swappable.class.isAssignableFrom(param)) {
            controller = param.getConstructor(Swapper.class).newInstance(swapper);
        } else {
            controller = param.getConstructor().newInstance();
        }
    } catch (ReflectiveOperationException ex) {
        throw new RuntimeException(ex);
    }
    return controller;
}