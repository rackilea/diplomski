import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class OptionList {
  private List<String> option;

  @XmlElement(name = "Option")
  public List<String> getOption() {
    return option;
  }

  public void setOption(List<String> option) {
    this.option = option;
  }
}