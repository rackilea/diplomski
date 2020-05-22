Person demo = new Person("Chris");

XStream xStream = new XStream();
xStream.alias("person", Person.class);
System.out.println(xStream.toXML(demo));

XStream xStream2 = new XStream();
xStream2.alias("dev", Person.class);
System.out.println(xStream2.toXML(demo));