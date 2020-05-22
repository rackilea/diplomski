package forum13219778;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "fixture_statistics")
@XmlAccessorType(XmlAccessType.FIELD)
public class FixtureStatistics {

    FixturePlayerStatistics guest_player_1;
    FixturePlayerStatistics guest_player_2;
    FixturePlayerStatistics guest_player_3;
    ...
    FixturePlayerStatistics guest_player_22;

    FixturePlayerStatistics home_player_1;
    FixturePlayerStatistics home_player_2;
    FixturePlayerStatistics home_player_3;
    ...
    FixturePlayerStatistics home_player_22;     
}