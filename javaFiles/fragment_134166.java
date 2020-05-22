package forum13404583;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
class Edge {

    @XmlAttribute
    @XmlIDREF
    Vertex end1;

    @XmlAttribute
    @XmlIDREF
    Vertex end2;

}