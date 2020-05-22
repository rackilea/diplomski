Serializer ser = new Persister(new AnnotationStrategy());

final String xml = "<example>\n"
        + "   <key1>value1</key1>\n"
        + "   <key2>value2</key2>\n"
        + "   <key3>value3</key3>\n"
        + "</example>";

Example e = ser.read(Example.class, xml);
System.out.println(e);