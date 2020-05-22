Map<String, Object> properties = new HashMap<String, Object>(1);
    List<String> bindingFiles = new ArrayList<String>(2);
    bindingFiles.add("version2.xml");
    bindingFiles.add("version3.xml");
    properties.put(JAXBContextFactory.ECLIPSELINK_OXM_XML_KEY, bindingFiles);
    JAXBContext jc = JAXBContext.newInstance(new Class[] {WeatherReport.class}, properties);