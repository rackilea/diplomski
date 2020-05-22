@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlParameters {
   String[] value();    
}

@Test(dataProvider = "XMLFileLoader")
@XmlParameters({"username", "password"})
public void testSomething(String username, String password) {
    // implementation omitted for brevity
}

@DataProvider(name = "XMLFileLoader")
public static Object[][] getDataFromXmlFile(final Method testMethod) {
    XmlParameters parameters = testMethod.getAnnotation(XmlParameters.class);
    String[] fields = parameters.value();
    //load just the fields you want
    return new Object[][] { { "user1", "pass1" } };
}