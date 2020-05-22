static class TestClass {
    @JsonRequired
    @SerializedName(value="testName", alternate = {"TestName", "tn", "tn2"})
    private String testName;
}



public static void main(String[] args) {
    Gson gsonUpperCamelCase = new GsonBuilder()
            .registerTypeAdapter(TestClass.class,
                    new AnnotatedDeserializer<TestClass>())
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .create();

    TestClass tc = gsonUpperCamelCase.fromJson("{\r\n" + 
            "   \"TestName\":\"name\"\r\n" + 
            "}", TestClass.class);

    System.out.println(tc.testName);

    System.out.println(gsonUpperCamelCase.toJson(tc));
}