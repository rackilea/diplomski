public static interface EpicCoolInterface<T> {
    // Return Type rather than Class, because T not always be a class.
    // You can do type check and return Class<T> with force typecast.
    default Type getParameterizedTypeClass() {
      return GenericUtil.getGenericTypes(getClass(), EpicCoolInterface.class)[0];
    }
  }