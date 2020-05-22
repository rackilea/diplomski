package forum11262807;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("serial")
public class MyObject2 implements Serializable {

    String x;
    String y;
    List<String> z;

}