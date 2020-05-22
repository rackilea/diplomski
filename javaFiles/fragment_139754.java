AbstractApplicationContext appContext =
    new ClassPathXmlApplicationContext(
        new String[] {"applicationContext.xml"}, false
    );
appContext.getEnvironment().getPropertySources().addLast(
   new CustomPropertySource()
);
appContext.refresh();