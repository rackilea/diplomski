final Constructor<?>[] ctrs = listenerClass.getConstructors();
    for (Constructor<?> constructor : ctrs) {
        if (constructor.getParameterTypes()[0].isAssignableFrom(MyAppState.class)) {
            // use this one?
        }
    }