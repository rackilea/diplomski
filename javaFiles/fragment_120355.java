public class Response {
   private String code;
   private List list;

   @XmlElement(name="code")
   public String getCode() {
     return code;
   }

  public void setCode(String code) {
    this.code = code;
  }

  @XmlElement(name= "list")
  public List getlist() {
    return this.list;
  }

  public void setList(List list) {
    this.list = list;
  }