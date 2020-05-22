@DataProvider(name = "DataProviderArray")
protected static Iterator<Object[]> getCoreDataProviderArray(Method superMethod, ITestContext context) {

  Class<?> type = superMethod.getParameterTypes()[0];     
  JsonUtils jsonUtils = new JsonUtils(TEST_DATA_LOCATION
    + context.getName() + JSON_EXTENSION);  
  List<Object> newUsers;
  try {
    newUsers = jsonUtils.createObjectsFromJsonFile(type);
  } catch (Exception e) {
    throw new RuntimeInterruptionException("Could not return object for "
                + superMethod.getParameterTypes()[0] + "...");
  }

  List<Object[]> objects = new ArrayList<>();
  for (Object user : newUsers) {
    objects.add(new Object[]{user});
  }
  return objects.iterator();
}