@XmlRootElement(name="LEVEL")
@XmlSeeAlso({Room.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Level {

    @XmlElement(name="LABEL")
    private String Label;

    @XmlElement(name="HEIGHT")
    private String Height;

    @XmlElement(name="ROOM")
    private Room rooms[];

    public Room[] getRoom() {
        return rooms;
    }

    public void setRoom(Room[] room) {
        this.rooms = room;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    @Override
    public String toString() {
        return "Level [Label=" + Label + ", Height=" + Height + ", rooms="
                + Arrays.toString(rooms) + "]";
    }
}