ApplicationContext applicationContext =
    newClassPathXmlApplicationContext("application-context.xml");

UserAccountServiceImpl service = applicationContext.getBean("UserAccountServiceImpl",
    UserAccountServiceImpl.class);

System.out.println(service);

service=SpringContextListener.getBean("UserAccountServiceImpl",UserAccountServImpl.class);

System.out.println(service);