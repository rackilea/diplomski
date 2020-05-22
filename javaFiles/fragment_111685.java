Function<Object, Object> createFun = o -> {
  try {
    return constructor.newInstance(o);
  } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
    return uncheck(e);
  }
};