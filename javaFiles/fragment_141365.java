public static String java2xml(Object obj, Class<?> T) {
    XStream xstream = new XStream(new StaxDriver());
    xstream.processAnnotations(T);
    StringWriter stringWriter = new StringWriter();
    xstream.marshal(obj, new PrettyPrintWriter(stringWriter));
    return stringWriter.toString();
}