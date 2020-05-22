@Bean
@DependsOn("globalVariables")
public GlobalVariablesPropertyLoader globalVariablesPropertyLoader() {
    GlobalVariablesPropertyLoader globalVariablesPropertyLoader = new GlobalVariablesPropertyLoader();
    globalVariablesPropertyLoader.getPropertyFiles().add("classpath:global.properties");
    return globalVariablesPropertyLoader;
}