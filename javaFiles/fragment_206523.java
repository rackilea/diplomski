private static void writeAsXml(Object o, Writer writer) throws Exception
  {
    JAXBContext jaxb = JAXBContext.newInstance(o.getClass());

    Marshaller xmlConverter = jaxb.createMarshaller();
    xmlConverter.setProperty("jaxb.formatted.output", true);
    xmlConverter.marshal(o, writer);
  }


CustomMap map = new CustomMap();
    map.addEntry("Key1","Value1");
    map.addEntry("Key2","Value2");
    map.addEntry("Key3","Value3");
    map.addEntry("Key4","Value4");
    writeAsXml(map, new PrintWriter(System.out));