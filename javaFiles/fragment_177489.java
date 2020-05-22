@XmlRootElement
public class Data {

    @XmlElement(name="entry")
    private List<Entry> entries;

    public List<Entry> getEntries() {
        return entries;
    }

    public static class Entry {

        @XmlElement
        private String key;

        @XmlElement
        private String value;

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

    }

}