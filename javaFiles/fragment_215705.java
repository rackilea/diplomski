@XmlRootElement(name = "getSingleSignOnTokenResponse", namespace = "http://convio.com/crm/v1.0")
public class SingleSignOnResponseBean
{
  @XmlElement(name = "token", namespace = "http://convio.com/crm/v1.0")
  public String token;
  @XmlElement(name = "cons_id", namespace = "http://convio.com/crm/v1.0")
  public int consId;
}