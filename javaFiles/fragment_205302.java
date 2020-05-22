package forum14193944;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlJavaTypeAdapter(AdapterCDATA.class)
    private String name;

    @XmlJavaTypeAdapter(AdapterCDATA.class)
    private String surname;

    @XmlJavaTypeAdapter(AdapterCDATA.class)
    private String id;

}