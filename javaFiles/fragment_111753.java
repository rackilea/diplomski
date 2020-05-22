FXMLLoader loader = new FXMLLoader();
loader.setLocation(/* your location */);
loader.setControllerFactory(clazz -> {
    if (YourController.class.equals(clazz)) {
        return new YourController(this);
    } else {
        try {
            return clazz.getConstructor().newInstance();
        } catch (ReflectiveOperationException ex) {
            throw new RuntimeException(ex); // bail
        }
    }
});
Parent root = loader.load();