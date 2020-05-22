// (1) Optional step to install the container from a URL pointing to its distribution
    Installer installer = new ZipURLInstaller(
        new URL("http://repo1.maven.org/maven2/com/ibm/websphere/appserver/runtime/wlp-javaee7/8.5.5.9/wlp-javaee7-8.5.5.9.zip"));
    installer.install();

    // (2) Create the Cargo Container instance wrapping our physical container
    LocalConfiguration configuration = (LocalConfiguration) new DefaultConfigurationFactory().createConfiguration(
        "liberty", ContainerType.INSTALLED, ConfigurationType.STANDALONE);
    InstalledLocalContainer container =
        (InstalledLocalContainer) new DefaultContainerFactory().createContainer(
            "liberty", ContainerType.INSTALLED, configuration);
    container.setHome(installer.getHome());

    // (3) Statically deploy some WAR (optional)
    WAR war = new WAR("cargo.war");
    // (4) Set the context root for the application
    war.setContext("/myContext");
    configuration.addDeployable(war);

    // (5) Start the container
    container.start();