@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Root", propOrder = {"ps"})
public class Root {

    protected List<PropertySequence> ps;
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ps", propOrder = {"p"})
public class PropertySequence {

    protected List<Property> p;

    public List<Property> getP() {
        if (p == null) {
            p = new ArrayList<>();
        }
        return this.p;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Property property : p) {
            builder.append(property).append(System.lineSeparator());
        }
        return builder.toString();
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "p", propOrder = {"content"})
public class Property {

    @XmlMixed
    @XmlElementRef(name = "ps", type = JAXBElement.class, required = false)
    protected List<Serializable> content;

    @XmlAttribute(name = "name")
    protected String name;

    @XmlAttribute(name = "vt")
    protected String vt;

    @XmlTransient
    public String getStringValue() {
        if (content != null && content.size() == 1) {
            return content.get(0).toString();
        }

        return null;
    }

    @XmlTransient
    public PropertySequence getPropertySequence() {
        if (content != null && content.size() == 3) {
            return ((JAXBElement<PropertySequence>) content.get(1)).getValue();
        }

        return null;
    }

    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<>();
        }
        return this.content;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getVt() {
        return vt;
    }

    public void setVt(String value) {
        this.vt = value;
    }

    @Override
    public String toString() {
        Object value = getStringValue();
        if (value == null) {
            value = getPropertySequence();
        }
        return "Property{" +
                "content=" + value +
                ", name='" + name + '\'' +
                ", vt='" + vt + '\'' +
                '}';
    }
}

@XmlRegistry
public class ObjectFactory {

    private final static QName ROOT_QNAME = new QName("", "Root");
    private final static QName PropertySequence_QNAME = new QName("", "ps");

    @XmlElementDecl(namespace = "", name = "Root")
    public JAXBElement<Root> createRoot(Root value) {
        return new JAXBElement<>(ROOT_QNAME, Root.class, null, value);
    }

    @XmlElementDecl(namespace = "", name = "ps", scope = Property.class)
    public JAXBElement<PropertySequence> createPropertySequence(PropertySequence value) {
        return new JAXBElement<>(PropertySequence_QNAME, PropertySequence.class, Property.class, value);
    }
}