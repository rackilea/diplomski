@XmlAccessorType(XmlAccessType.FIELD)    
public class PingRequest
{
    @XmlAttribute
    private String echo;

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }
}