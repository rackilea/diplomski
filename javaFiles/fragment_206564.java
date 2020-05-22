// (1) Optional step to install the container from a URL pointing to its distribution
Installer installer = new ZipURLInstaller(new URL("http://www.apache.org/dist/tomcat/tomcat-6/v6.0.20/bin/apache-tomcat-6.0.20.zip"));
installer.install();

// (2) Create the Cargo Container instance wrapping our physical container
LocalConfiguration configuration = (LocalConfiguration) new DefaultConfigurationFactory()
        .createConfiguration("tomcat6x"), ContainerType.INSTALLED, ConfigurationType.STANDALONE);
container = (InstalledLocalContainer) new DefaultContainerFactory()
        .createContainer("tomcat6x", ContainerType.INSTALLED, configuration);
container.setHome(installer.getHome());

// (3) Statically deploy some WAR (optional)
WAR deployable = new WAR("./webapp-testing-webapp/target/webapp-testing-webapp-1.0.war");
deployable.setContext("ROOT");
configuration.addDeployable(deployable);

// (4) Start the container
container.start();