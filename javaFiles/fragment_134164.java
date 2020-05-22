package forum13404583;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Graph {

    @XmlElement(name = "vertex")
    List<Vertex> vertexList;

    @XmlElement(name = "edge")
    List<Edge> edgeList;

}