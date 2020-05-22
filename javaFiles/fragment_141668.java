import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Features_res")
public class InteriorResponse {

  @XmlElement(name = "StartWeek")
  private int sWeek;

  @XmlElement(name = "EndWeek")
  private int eWeek;

  @XmlElement(name = "Pno12")
  private String p12;

  private FeatureList featureList;

  private OptionList optionList;

  public InteriorResponse() {}

  public InteriorResponse(int startWeek, int endWeek, String pno12) {
    super();
    this.sWeek = startWeek;
    this.eWeek = endWeek;
    this.p12 = pno12;
  }

  public int getStartWeek() {
    return sWeek;
  }

  public void setStartWeek(int startWeek) {
    this.sWeek = startWeek;
  }

  public int getEndWeek() {
    return eWeek;
  }

  public void setEndWeek(int endWeek) {
    this.eWeek = endWeek;
  }

  public String getPno12() {
    return p12;
  }

  public void setPno12(String pno12) {
    this.p12 = pno12;
  }

  @XmlElement(name = "FeatureList")
  public FeatureList getFeatureList() {
    return featureList;
  }

  public void setFeatureList(FeatureList featureList) {
    this.featureList = featureList;
  }

  @XmlElement(name = "OptionList")
  public OptionList getOptionList() {
    return optionList;
  }

  public void setOptionList(OptionList optionList) {
    this.optionList = optionList;
  }

  @Override
  public String toString() {
    return "InteriorResponse{"
        + "sWeek="
        + sWeek
        + ", eWeek="
        + eWeek
        + ", p12='"
        + p12
        + '\''
        + ", featureList="
        + featureList
        + ", optionList="
        + optionList
        + '}';
  }
}