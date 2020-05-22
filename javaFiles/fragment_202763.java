package forum11311374;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Datas {

  @XmlElement(name="data")
  private List<Data> datas;

  //get/set methods

}