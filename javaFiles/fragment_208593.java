@XmlRootElement(name="ROOM")
@XmlSeeAlso({Door.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Room {

    @XmlElement(name="LABEL")
    private String label;

    @XmlElement(name="TYPE")
    private String type;    

    @XmlElement(name="HEIGHT")
    private String height;

    @XmlElement(name="WIDTH")
    private String width;

    @XmlElement(name="LENGTH")
    private String length;

    @XmlElement(name="CAPACITY")
    private String capacity;

    @XmlElement(name="SPRINKLER")
    private String sprinkler;

    @XmlElement(name="SMOKEDETECTOR")
    private String smokeDet;

    @XmlElement(name="EXTINGUISHERNUMBER")
    private String extNum;

    @XmlElement(name="DOORNUMBER")
    private String doorNumber;

    @XmlElement(name="DOOR")
    Door doors[];

    public Door[] getDoor() {
        return doors;
    }
    public void setDoor(Door[] door) {
        this.doors = door;
    }
    public String getHeight() {
        return height;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public String getWidth() {
        return width;
    }
    public void setWidth(String width) {
        this.width = width;
    }
    public String getLength() {
        return length;
    }
    public void setLength(String length) {
        this.length = length;
    }
    public String getCapacity() {
        return capacity;
    }
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    public String getSprinkler() {
        return sprinkler;
    }
    public void setSprinkler(String sprinkler) {
        this.sprinkler = sprinkler;
    }
    public String getSmokeDet() {
        return smokeDet;
    }
    public void setSmokeDet(String smokeDet) {
        this.smokeDet = smokeDet;
    }
    public String getExtNum() {
        return extNum;
    }
    public void setExtNum(String extNum) {
        this.extNum = extNum;
    }
    public String getDoorNumber() {
        return doorNumber;
    }
    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room [label=" + label + ", type=" + type + ", height=" + height
                + ", width=" + width + ", length=" + length + ", capacity="
                + capacity + ", sprinkler=" + sprinkler + ", smokeDet="
                + smokeDet + ", extNum=" + extNum + ", doorNumber="
                + doorNumber + ", doors=" + Arrays.toString(doors) + "]";
    }    

}