String[] xmlFies=new String[1];
xmlFies[0]="applicationContext.xml";

ClassPathXmlApplicationContext parentContext = new ClassPathXmlApplicationContext("tokenConfiguration.xml");
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlFies, parentContext);
. . .