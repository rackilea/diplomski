<!-- language: java -->
@XmlRootElement(name = "myRequest")
public class MyRequest {

    @XmlElement(required = true)
    private String token;

    private List<int> flags = new ArrayList<int>();

    @XmlJavaTypeAdapter(value = JaxbXml2MapAdapter.class)
    private HashMap<String, String> options = new HashMap<String, String>();

    public MyRequest() {
    }

    // .... blah blah blah
}