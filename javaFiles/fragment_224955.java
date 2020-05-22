@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "project")
public class Project {

    @XmlElement(name ="result")
    private String result;    

    public Project() {
    }

    public String getResult() {
        return result;
    }

    public void setResult (String result) {
        this.result = result;
    }  
}