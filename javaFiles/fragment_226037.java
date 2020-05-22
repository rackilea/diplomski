/**
 * Method to convert list objects to XML using XStream API.
 * <p>
 * 
 * @param list
 * @param domainClass
 * @param columnIds
 */
public static final String listToXML(List<?> list, Class<?> domainClass,
        Converter converter) {
    String xml = "";
    StringBuffer buff = new StringBuffer(1000);
    buff.append("<?xml version='1.0' encoding='UTF-8'?>");

    XStream xstream = new XStream(new DomDriver());
    if (list != null && list.size() > 0) {

        xstream.alias("rows", List.class);

        xstream.processAnnotations(domainClass);
        xstream.registerConverter(converter);

        xml = xstream.toXML(list);
    } else {
        buff.append("<rows/>");
    }
    xml = buff.append(xml).toString();  
    return xml;

}