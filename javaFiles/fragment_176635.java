@XmlAccessorType(value = XmlAccessType.NONE)
@XmlRootElement(name = "url")
public class XmlUrl {
    public enum Priority {
        HIGH("1.0"), MEDIUM("0.5");

        private String value;

        Priority(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @XmlElement
    private String loc;

    @XmlElement
    private String lastmod = new DateTime().toString(DateTimeFormat.forPattern("yyyy-MM-dd"));

    @XmlElement
    private String changefreq = "daily";

    @XmlElement
    private String priority;

    public XmlUrl() {
    }

    public XmlUrl(String loc, Priority priority) {
        this.loc = loc;
        this.priority = priority.getValue();
    }

    public String getLoc() {
        return loc;
    }

    public String getPriority() {
        return priority;
    }

    public String getChangefreq() {
        return changefreq;
    }

    public String getLastmod() {
        return lastmod;
    }
}