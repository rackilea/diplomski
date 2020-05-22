ExclusionStrategy strategy = new ExclusionStrategy() {
    @Override
    public boolean shouldSkipField(FieldAttributes field) {
        if (field.getDeclaringClass() == MyClass.class && field.getName().equals("other")) {
            return true;
        }
        if (field.getDeclaringClass() == MySubClass.class && field.getName().equals("otherVerboseInfo")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
};

Gson gson = new GsonBuilder()
  .addSerializationExclusionStrategy(strategy)
  .create();
String jsonString = gson.toJson(source);

assertEquals(expectedResult, jsonString);