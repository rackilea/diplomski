SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = saxParserFactory.newSAXParser();
    org.apache.xerces.util.SecurityManager mgr = new org.apache.xerces.util.SecurityManager();
    mgr.setEntityExpansionLimit(1000000);
    saxParser.setProperty("http://apache.org/xml/properties/security-manager", mgr);
    MyHandler handler = new MyHandler();

    // THIS LINE IS CAUSING THE ERROR
    saxParser.parse(new File("JMdict"), handler);
    // Get entries list
    List<Entry> entryList = handler.getEmpList();
    // print entry information
    for (Entry ent : entryList)
        System.out.println(ent);