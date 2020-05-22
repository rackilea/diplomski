@XmlRootElement(name="Province")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="DictionaryProvince")
public class DictionaryProvince extends Dictionary {
    @XmlElement(required=true)
    private String code;
    // ...
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Dictionary",propOrder={"description"})
public class Dictionary {  // no need for Serializable
    // ... as before
}

@XmlRegistry
public class ObjectFactory {
    private final static QName _dict_QNAME = new QName("", "dict");
    public ObjectFactory() {
    }
    @XmlElementDecl(namespace = "", name = "Province")
    public JAXBElement<DictionaryProvince> 
    createDictionaryProvince(DictionaryProvince value) {
        return new JAXBElement<DictionaryProvince>(_dict_QNAME, DictionaryProvince.class, null, value);
    }
}