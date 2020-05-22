public static <T extends Event> void call(
   EventExecutor<T> eventExecutor, Class<T> eventClass, Object... eventArgs) {
  synchronized (LOCK) {
    if (!checkIsEventClassRegistered(eventClass)) return;
    try {
      Class<?>[] constructorParameters = EventUtilities.getArrayOfClasses(
          eventArgs);
      Constructor<?> constructor = eventClass.getDeclaredConstructor(
          constructorParameters);

      T event = eventClass.cast(constructor.newInstance(eventArgs));

      if (!callAllRegisteredMethods(event)) eventExecutor.execute(event);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}