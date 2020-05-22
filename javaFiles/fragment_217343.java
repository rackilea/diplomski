FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("TabLayout.fxml"));

ObservableList<Visite> data = FXCollections.observableArrayList();

loader.setControllerFactory((Class<?> controllerType) -> {
    try {
        Constructor<?>[] constructors = controllerType.getConstructors();
        for (Constructor<?>[] constructor : constructors) {
            if (constructor.getParameterCount() == 1 &&
                constructor.getParameterTypes()[0] == ObservableList.class)

                return constructor.newInstance(data);
            }
        }

        // no suitable constructor found, just use default:
        return controllerType.newInstance();

    } catch (Exception exc) {
        System.out.println("Could not create controller:");
        exc.printStackTrace();
        return null ;
    }
});

JFXTabPane root = loader.load();

// ...