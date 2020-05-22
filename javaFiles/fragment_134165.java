package forum13404583;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
class Vertex {

    @XmlAttribute
    @XmlID
    String id;

    @XmlAttribute
    String color;

    @XmlAttribute
    Integer thickness;

}