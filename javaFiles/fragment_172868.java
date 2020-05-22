@XmlRootElement(name = "config")
public class Cfg {
    public Cfg() {
    }

    @XmlElementWrapper(name = "avoidanceList")
    @XmlElement(name = "avoid", required = false)
    private List<String> avoidanceList;

    @XmlElementWrapper(name = "ignoreList")
    @XmlElement(name = "ignore", required = false)
    private List<String> ignoreList;

    @XmlElement(name = "mailConfig")
    private MailConfig mailConfig;


    public List<String> getAvoidanceList() {
        return avoidanceList;
    }

    public List<String> getIgnoreList() {
        return ignoreList;
    }

    public MailConfig getMailConfig() {
        return mailConfig;
    }
}

public class MailConfig {
    @XmlElementWrapper(name = "toList")
    @XmlElement(name = "to")
    private List<String> toList;

    @XmlElement(name = "from", required = false)
    private String from;

    public MailConfig() {
    }

    public String getFrom() {
        return from;
    }

    public List<String> getToList() {
        return toList;
    }
}