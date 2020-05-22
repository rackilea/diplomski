@XmlRootElement(name = "subscriptionRequest") 
public class RegistrationRequest { 

    private Long id; 
    private RegistrationSource registrationSource; 

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @XmlAttribute
    public RegistrationSource getRegistrationSource() { return registrationSource; }
    public void setRegistrationSource(RegistrationSource registrationSource)
    {
        this.registrationSource = registrationSource;
    }
}