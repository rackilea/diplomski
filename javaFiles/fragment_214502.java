public class Employee {

    private String division;

    private String firstname;

    private String id;

    private String title;

    private String building;

    private String room;

    private String supervisor;

    private String lastname;

    public String getDivision() {
        return division;
    }

    @XmlElement(name = "division")
    public void setDivision(String division) {
        this.division = division;
    }

    public String getFirstname() {
        return firstname;
    }

    @XmlElement(name = "firstname")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement(name = "title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBuilding() {
        return building;
    }

    @XmlElement(name = "building")
    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    @XmlElement(name = "room")
    public void setRoom(String room) {
        this.room = room;
    }

    public String getSupervisor() {
        return supervisor;
    }

    @XmlElement(name = "supervisor")
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getLastname() {
        return lastname;
    }

    @XmlElement(name = "lastname")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "ClassPojo [division = " + division + ", firstname = " + firstname + ", id = " + id + ", title = "
                + title + ", building = " + building + ", room = " + room + ", supervisor = " + supervisor
                + ", lastname = " + lastname + "]";
    }
}