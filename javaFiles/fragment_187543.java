package forum10699038;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Metadata {

    @XmlElement(name="artist-list")
    ArtistList artistList;

}