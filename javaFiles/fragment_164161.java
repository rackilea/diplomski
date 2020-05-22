private ConfigurationProvider configureProvider() {
    ClassLoader classLoader = getClass().getClassLoader();
    String envPath = classLoader.getResource("properties").getPath();
    Path localPropertiesFilePath = Paths.get(envPath, "local.properties");
    Path basePropertiesFilePath = Paths.get(envPath, "base.properties");

    if (!Files.exists(localPropertiesFilePath)) {
        try {
            Files.createFile(localPropertiesFilePath);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    ConfigFilesProvider localConfigFilesProvider =
            () -> Collections.singletonList(localPropertiesFilePath);
    ConfigFilesProvider baseConfigFilesProvider =
            () -> Collections.singletonList(basePropertiesFilePath);

    ConfigurationSource local = new FilesConfigurationSource(localConfigFilesProvider);
    ConfigurationSource base = new FilesConfigurationSource(baseConfigFilesProvider);
    // If you have 'some' property in base and local files - it takes from local
    ConfigurationSource mergedSource = new MergeConfigurationSource(base, local);

    Environment environment = new ImmutableEnvironment(envPath);

    return new ConfigurationProviderBuilder()
            .withConfigurationSource(mergedSource)
            .withEnvironment(environment)
            .build();
}