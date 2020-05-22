import javax.xml.bind.annotation.XmlElement;

public class Feature {

  @XmlElement(name = "Code")
  private String code_;

  public String getCode() {
    return code_;
  }

  public void setCode(String code) {
    this.code_ = code;
  }

  @Override
  public String toString() {
    return "Feature{" + "code_='" + code_ + '\'' + '}';
  }
}