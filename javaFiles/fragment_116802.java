Root ref = new Root();
ref.setKeyValueList(Arrays.asList(
        new Wrapper("k1", "v1"),
        new Wrapper("k2", "v2")));
XmlMapper xmlMapper = new XmlMapper();
String output = xmlMapper.writeValueAsString(ref);
System.out.println(output);