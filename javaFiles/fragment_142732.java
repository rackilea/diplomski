@XmlRootElement(name = "id")
public class XMLObject
{
  int id;
  String value;

  public int getId()
  {
    return id;
  }

  @XmlAttribute
  public void setId(int id)
  {
    this.id = id;
  }

  public String getValue()
  {
    return value;
  }

  @XmlAttribute
  public void setValue(String value)
  {
    this.value = value;
  }
}