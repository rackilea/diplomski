@XmlRootElement(name = "map")
public class MapElement {

    @XmlElement(name = "entry")
    public List<EntryElement> entries = new ArrayList<EntryElement>();

    public void addEntry(String key, String value) {
        entries.add(new EntryElement(key, value));
    }

}