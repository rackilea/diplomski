@XmlType
public class MapWrapper{
    private List<JAXBElement<String>> properties = new ArrayList<>();

    public MapWrapper(){

    }

    @XmlAnyElement
    public List<JAXBElement<String>> getProperties() {
        return properties;
    }
    public void setProperties(List<JAXBElement<String>> properties) {
        this.properties = properties;
    }
    public void addEntry(JAXBElement<String> prop){
        properties.add(prop);
    }

    public void addEntry(String key, String value){
        JAXBElement<String> prop = new JAXBElement<String>(new QName(key), String.class, value);
        addEntry(prop);
    }

}