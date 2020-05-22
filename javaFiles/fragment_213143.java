public class Item {

    @XmlElement
    private String id;

    @XmlElement
    private String type;

    @XmlAnyElement
    private List<Element> otherElements;

    @XmlTransient  // don't participate in JAXB marshalling/unmarshalling
    private Map<String, String> values;

    @SuppressWarnings("unused")   // called only by JAXB
    private void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        values = new HashMap<>();
        if (otherElements != null) {
            for (Element element : otherElements) {
                String key = element.getNodeName();
                String value = element.getFirstChild().getNodeValue();
                values.put(key, value);
            }
        }
    }

}