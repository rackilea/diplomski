@XmlRootElement(name="procedure")
public class Procedure {
    @XmlElement(name="procedure")
    public List<Params> procedures = new LinkedList<Params>();
}
public class Params {
   @XmlElement(name="param")
   public List<String> params = new LinkedList<String>();
}