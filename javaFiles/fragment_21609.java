public class Item 
{

    private String name;

    private String type;

    private String lastModified;

    private List<Value> values;

    private String isSpecial;


    @XmlPath("values/value/@is_special")
    public String getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(String isSpecial) {
       this.isSpecial = isSpecial;
    }

    @XmlElement(name="type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name="last_modified")
    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }


    @XmlElement(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @XmlElementWrapper(name="values")
    @XmlElement(name="value")
    public List<Value> getValues() {
        return values;
    }


    public void setValues(List<Value> values) {
        this.values = values;
    }


}