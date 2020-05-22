package forum11262807;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="myObject1")
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("serial")
public class MyObject1 implements Serializable {

    MyObject2 a;
    MyObject2 b;
    MyObject2 c;

}