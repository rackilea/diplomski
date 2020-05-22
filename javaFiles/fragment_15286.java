public static <T> String getXmlString(T data) {
    final StringWriter stringWriter = new StringWriter();

    XStream xstream = new XStream(new StaxDriver());
    xstream.autodetectAnnotations(true);
    xstream.marshal(data, new PrettyPrintWriter(stringWriter));

    return stringWriter.toString();
}