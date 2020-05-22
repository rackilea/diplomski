public Constructor<?> getPrimitiveSingleArgConstructor(Class<?> myC) {

  for( Constructor<?> constructor : myC.getConstructors() ) {
    if( constructor.getParameterTypes().length == 1 ) {
      Class<?> paramType = constructor.getParameterTypes()[0];
      if (paramType.isPrimitive()) {
        return constructor;
      }
    }
  }
}