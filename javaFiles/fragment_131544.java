package forum13219778;

import java.util.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "fixture_statistics")
@XmlAccessorType(XmlAccessType.FIELD)
public class FixtureStatistics {

    @XmlElementRefs({ 
        @XmlElementRef(name="home_player_1"),
        @XmlElementRef(name="home_player_2"),
        @XmlElementRef(name="home_player_3")
    })
    private Collection<JAXBElement<FixturePlayerStatistics>> homeTeamPlayerStatistics = new ArrayList<>();

    @XmlElementRefs({ 
        @XmlElementRef(name="guest_player_1"),
        @XmlElementRef(name="guest_player_2"),
        @XmlElementRef(name="guest_player_3")
    })
    private Collection<JAXBElement<FixturePlayerStatistics>> guestTeamPlayerStatistics = new ArrayList<>();

}