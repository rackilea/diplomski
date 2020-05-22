@XmlRootElement(name = "DOOR")
@XmlAccessorType(XmlAccessType.FIELD)
public class Door {

    @XmlElement(name="ID")
    private String id;

    @XmlElement(name="TYPE")
    private String type;

    @XmlElement(name="CAPACITY")
    private String capacity;

    @XmlElement(name="POSITION")
    private String position;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Override
    public String toString() {
        return "Door [id=" + id + ", type=" + type + ", capacity=" + capacity
                + ", position=" + position + "]";
    }
}