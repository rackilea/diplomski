Model model = new Model() ;
Callback<Class<?>, Object> controllerFactory = clazz -> {
    try {
        // see if controller class has a constructor taking a Model:
        for (Constructor<?> constructor : class.getConstructors()) {
            if (constructor.getParameterCount() == 1 
               && constructor.getParameterTypes()[0] == Model.class) {
                return constructor.newInstance(model);
            }
        }
        // no suitable constructor, just invoke no-arg constructor:
        return clazz.newInstance();
    } catch (RuntimeException exc) {
        throw exc ;
    } catch (Exception exc) {
        throw new RuntimeException(exc);
    }
};
FXMLLoader loader = new FXMLLoader(...);
loader.setControllerFactory(controllerFactory);
Parent mainView = loader.load();