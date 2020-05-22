public static List<String> getXMLElements(Class<?> clazz) {
    XmlType xmlType = clazz.getAnnotation(XmlType.class);
    if (xmlType == null)
        return null;
    String[] propOrder = xmlType.propOrder();
    return Arrays.asList(propOrder);
}