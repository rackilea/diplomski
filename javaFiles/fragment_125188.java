@XmlRootElement(name="person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlAttribute(name="name")
    private String name;

    @XmlAnyAttribute
    private Map<QName, String> otherAttributes;

    @XmlTransient // don't participate in marshalling/unmarhalling
    private List<String> phoneNumbers;

    @XmlTransient // don't participate in marshalling/unmarhalling
    private List<String> addresses;

    // add public getters/setters for name, addresses, phoneNumbers,
    // but not for otherAttributes

    @SuppressWarnings("unused") // called by JAXB
    private void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        addresses = new ArrayList<>();
        phoneNumbers = new ArrayList<>();
        for (QName qName : otherAttributes.keySet()) {
             if (qName.getLocalPart().startsWith("address")) {
                 addresses.add(otherAttributes.get(qName));
             }
             if (qName.getLocalPart().startsWith("phoneNumber")) {
                 phoneNumbers.add(otherAttributes.get(qName));
             }
        }
    }

    @SuppressWarnings("unused") // called by JAXB
    private boolean beforeMarshal(Marshaller marshaller) {
        otherAttributes = new HashMap<>();
        int i = 0;
        for (String address : addresses) {
            otherAttributes.put(new QName("address" + ++i), address);
        }
        i = 0;
        for (String phoneNumber : phoneNumbers) {
            otherAttributes.put(new QName("phoneNmber" + ++i), phoneNumber);
        }
        return true;
    }
}