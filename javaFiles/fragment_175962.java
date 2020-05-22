@Parameters({"featurePath"})
@BeforeTest(alwaysRun = true)
public void setUpTest(@Optional("src/main/java/cucumberFeatureFiles/Testcase.feature") String featurePath) throws Exception {   
    Class<?> testClass = this.getClass();
    changeCucumberAnnotation(testClass, "features", new String [] {featurePath});       
    testNGCucumberRunner = new WaltersTestngCucumberRunner(testClass);        
}

private static void changeCucumberAnnotation(Class<?> clazz, String key, Object newValue) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{  
    Annotation options = clazz.getAnnotation(CucumberOptions.class);                   //get the CucumberOptions annotation  
    InvocationHandler proxyHandler = Proxy.getInvocationHandler(options);              //setup handler so we can update Annotation using reflection. Basically creates a proxy for the Cucumber Options class
    Field f = proxyHandler.getClass().getDeclaredField("memberValues");                //the annotaton key/values are stored in the memberValues field
    f.setAccessible(true);                                                             //suppress any access issues when looking at f
    Map<String, Object> memberValues = (Map<String, Object>) f.get(proxyHandler);      //get the key-value map for the proxy
    memberValues.remove(key);                                                          //renove the key entry...don't worry, we'll add it back
    memberValues.put(key,newValue);                                                    //add the new key-value pair. The annotation is now updated.
}//end method