Properties prop = new Properties();
prop.setProperty("root", "some root");
prop.setProperty("port", "8020");
prop.store(new FileWriter("config.txt"), "test");

Properties config = new Properties();
//loading properties from properties file
config.load(new FileReader("config.txt"));

int port = Integer.parseInt(config.getProperty("port"));
System.out.println("this is port " + port);