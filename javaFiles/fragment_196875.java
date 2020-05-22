XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans.xml"));
// create placeholderconfigurer to bring in some property
// values from a Properties file
PropertyPlaceholderConfigurer cfg = factory.getBean("<bean id of the property configurer>")
// now actually do the replacement
cfg.postProcessBeanFactory(factory);