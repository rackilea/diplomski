import java.util.Set;    
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="JobDetails")
public class JobDetails {

    public JobDetails() {
    // TODO Auto-generated constructor stub
}
    JobDetails(String str) {

    }

    @JacksonXmlProperty(localName="CompanyName")
    @JsonProperty("CompanyName")
    private String companyName;

    @JacksonXmlProperty(localName="Experience")
    @JsonProperty("Experience")
    private Float experience;

    @JacksonXmlProperty(localName="Location")
    @JsonProperty("Location")
    private String location;

    @JacksonXmlElementWrapper(localName="technologyList")
    @JsonProperty("Technologies")
    private Set<String> technologies;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public FloatgetExperience() {
        return experience;
    }

    public void setExperience(Floatexperience) {
        this.experience = experience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<String> technologies) {
        this.technologies = technologies;
    }

}