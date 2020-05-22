package forum10699038;

import javax.xml.bind.annotation.*;

@XmlType(propOrder={"name", "ipiList"})
public class Artist {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String type;

    @XmlAttribute(namespace="http://musicbrainz.org/ns/ext#-2.0")
    private String score;

    @XmlElement(name="ipi-list")
    private IPIList ipiList;

    private String name;

}