@XmlRootElement(name="MyElement")
public class MyElement {
  private String id;
  private String maybeHere;

  @XmlElement(name="ID")
  public String getId() {return id;}
  public void setId(String s){this.id = s;}

  @XmlElement(name="MaybeHere", required=false)
  public String getMaybeHere() {return maybeHere;}
  public void setMaybeHere(String s) { this.maybeHere = s;}
}