public class RegistrationSource { 

    private Integer id; 
    private String code; 

    @XmlTransient
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    @XmlValue
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}