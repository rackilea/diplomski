URL logConfig = null;
File xmlFile = new File("log4j.xml");
if(xmlFile.exists()) {
  logConfig = xmlFile.toURI().toURL();
} else {
  logConfig = MyMainClassName.class.getResource("default-log4j.xml");
}
DOMConfigurator.configure(logConfig);