import java.util.List;
    import java.util.Set;
    import org.springframework.data.annotation.Id;
    import org.springframework.data.mongodb.core.mapping.Document;
    import com.fasterxml.jackson.annotation.JsonProperty;
    import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
    import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
    import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

    @Document
    @JacksonXmlRootElement(localName="EmployeeDetail")
    public class Employee implements Serializable {

        @Id
        private String userId;

        @JacksonXmlProperty(localName="FirstName")
        @JsonProperty("FirstName")
        private String firstName;

        @JacksonXmlProperty(localName="LastName")
        @JsonProperty("LastName")
        private String lastName;

        @JacksonXmlProperty(localName="Age")
        @JsonProperty("Age")
        private Integer age;

        @JacksonXmlElementWrapper(localName="skillset")
        @JsonProperty("Skills")
        private Set<String> skills;

        @JacksonXmlElementWrapper(localName="jobs")
        @JsonProperty("JobDetails")
        private List<JobDetails> jobDetails;

        @JacksonXmlProperty(localName="TotalExperience")
        @JsonProperty("totalExperience")
        private Integer totalExperience;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public List<JobDetails> getJobDetails() {
            return jobDetails;
        }

        public void setJobDetails(List<JobDetails> jobDetails) {
            this.jobDetails = jobDetails;
        }

        public Set<String> getSkills() {
            return skills;
        }

        public void setSkills(Set<String> skills) {
            this.skills = skills;
        }

         public Integer getTotalExperience() {
            return totalExperience;
        }

        public void setTotalExperience(Integer totalExperience) {
            this.totalExperience = totalExperience;
        }
    }