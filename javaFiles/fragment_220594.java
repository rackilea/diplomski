FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editClient.fxml"));
fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
    @Override
    public Object call(Class<?> controllerClass) {
        if (controllerClass == EditClientController.class) {
            EditClientController controller = new EditClientController()
            controller.setIndex(clickIndex);
            return controller ;
        } else {
            try {
                return controllerClass.newInstance();
            } catch (Exception exc) {
                throw new RuntimeException(exc); // just bail
            }
        }
    }
});
Parent root1 = fxmlLoader.load();