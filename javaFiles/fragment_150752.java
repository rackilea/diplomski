String inputStr = "<f:table f:id=\"1\" xmlns:f=\"http://millka_15.namespace\">\n" +
        "  <f:name>African Coffee Table</f:name>\n" +
        "  <f:width>80</f:width>\n" +
        "  <f:length>120</f:length>\n" +
        "</f:table>";

StringReader stringReader = new StringReader(inputStr);
SAXBuilder builder = new SAXBuilder();
Document doc = builder.build(stringReader);

System.out.println(doc);