PropertiesConfiguration config = new PropertiesConfiguration(yourFile);
List<Object> list = config.getList("prop1");

for (Object object : list) {
  System.out.println(object);
}