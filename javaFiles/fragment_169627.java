@XmlRootElement(name = "entry_list")
public class EntryList {

    @XmlElement(name = "entry")
    private List<Entry> entities;

    public List<Entry> getEntities() {
        return entities;
    }
    public void setLastName(List<Entry> entities) {
        this.entities = entities;
    }
}

public class Entry {

    @XmlAttribute
    private String id;

    @XmlElement
    private Sound sound

    etc
    ...

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Sound getSound() {
        return sound;
    }
    public void setSound(Sound sound) {
        this.sound = sound;
    }
}