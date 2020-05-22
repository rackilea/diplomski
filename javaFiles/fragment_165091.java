@Bean
public GlobalVariables globalVariables() {
    GlobalVariables globalVariables = new GlobalVariables();
    globalVariables.getVariables().put("myVar", "foo");
    return globalVariables;
}