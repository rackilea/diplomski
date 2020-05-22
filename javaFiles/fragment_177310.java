private <T> T instantiate(Class<?> input, Object parameter) {
  try {
    Constructor<?> constructor = ConstructorUtils.getMatchingAccessibleConstructor(input, parameter.getClass());
    return (T) constructor.newInstance(parameter);
  } catch (Exception e) {
    //handle various exceptions
  } 
}