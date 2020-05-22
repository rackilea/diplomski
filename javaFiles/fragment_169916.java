@XmlRootElement
public class TestXML {
  private String testtype;
  private double duration;
  private String status;

  public void setTesttype(String testtype) {
    this.testtype = testtype;
  }
  @XmlAttribute
  public String getTesttype() {
    return testtype;
  }
  public void setDuration(double duration) {
    this.duration = duration;
  }
  @XmlAttribute
  public double getDuration() {
    return duration;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  @XmlValue
  public String getStatus() {
    return status;
  }

  public static void main(String args[]) {
    TestXML test = JAXB.unmarshal(new File("test.xml"), TestXML.class);

    System.out.println("testtype = " + test.getTesttype());
    System.out.println("duration = " + test.getDuration());
    System.out.println("status = " + test.getStatus());
  }
}