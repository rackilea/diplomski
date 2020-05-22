@XmlRootElement(name = "isomsg")
@XmlAccessorType(XmlAccessType.FIELD)
public class Isomsg
{

  @XmlElement(name = "id")
  private List<XMLObject> idList = null;

  public List<XMLObject> getIdList()
  {
    return idList;
  }

  public void setIdList(List<XMLObject> idList)
  {
    this.idList = idList;
  }
}