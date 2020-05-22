public static void main(String[] args) throws Exception {

    Configurations configurations = new Configurations();
    CompositeConfiguration compositeConfiguration = new CompositeConfiguration();

    Enumeration<URL> urls = ConfigurationTest2.class.getClassLoader().getResources("test.properties");
    while(urls.hasMoreElements()) {
        PropertiesConfiguration propertiesConfiguration = configurations.properties(urls.nextElement());
        compositeConfiguration.addConfiguration(propertiesConfiguration);
    }
    System.out.println(compositeConfiguration.getString("test1"));

}