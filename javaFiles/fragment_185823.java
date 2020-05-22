package forum12914382;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="Example")
@XmlAccessorType(XmlAccessType.FIELD)
class Example{

    @XmlJavaTypeAdapter(MyFieldAdapter.class)
    String myField;

}