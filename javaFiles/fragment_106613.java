import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public class Thing {
  private List<String> strings;

  public List<String> getStrings() {
    return strings;
  }

  public void setStrings(List<String> strings) {
      System.out.println("Thing" + strings);
    this.strings = strings;
  }

}