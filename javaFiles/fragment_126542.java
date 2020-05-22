ClassPathXmlApplicationContext parentAppContext = new ClassPathXmlApplicationContext();
parentAppContext.setConfigLocation("spring-core.xml"); // this is your core spring xml
parentAppContext.refresh();
ClassPathXmlApplicationContext moduleAppContext = new ClassPathXmlApplicationContext();
moduleAppContext.setConfigLocation("others.xml");
moduleAppContext.setParent(parentAppContext);
moduleAppContext.refresh();