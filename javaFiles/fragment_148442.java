@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responsedata")
public class ResponseData {
    @XmlElement(name = "numhits",namespace = "http://namespace.here")
    private String numhits;
    @XmlElement(name = "totalhits")
    private String totalhits;
}