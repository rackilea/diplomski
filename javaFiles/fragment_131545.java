package forum13219778;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    @XmlElementDecl(name = "home_player_1")
    public JAXBElement<FixturePlayerStatistics> createHomePlayer1(FixturePlayerStatistics player) {
        return new JAXBElement<FixturePlayerStatistics>(new QName("home_player_1"), FixturePlayerStatistics.class, player);
    }

    @XmlElementDecl(name = "home_player_2")
    public JAXBElement<FixturePlayerStatistics> createHomePlayer2(FixturePlayerStatistics player) {
        return new JAXBElement<FixturePlayerStatistics>(new QName("home_player_2"), FixturePlayerStatistics.class, player);
    }

    @XmlElementDecl(name = "home_player_3")
    public JAXBElement<FixturePlayerStatistics> createHomePlayer3(FixturePlayerStatistics player) {
        return new JAXBElement<FixturePlayerStatistics>(new QName("home_player_3"), FixturePlayerStatistics.class, player);
    }

    @XmlElementDecl(name = "guest_player_1")
    public JAXBElement<FixturePlayerStatistics> createGuestPlayer1(FixturePlayerStatistics player) {
        return new JAXBElement<FixturePlayerStatistics>(new QName("guest_player_1"), FixturePlayerStatistics.class, player);
    }


    @XmlElementDecl(name = "guest_player_2")
    public JAXBElement<FixturePlayerStatistics> createGuestPlayer2(FixturePlayerStatistics player) {
        return new JAXBElement<FixturePlayerStatistics>(new QName("guest_player_2"), FixturePlayerStatistics.class, player);
    }

    @XmlElementDecl(name = "guest_player_3")
    public JAXBElement<FixturePlayerStatistics> createGuestPlayer3(FixturePlayerStatistics player) {
        return new JAXBElement<FixturePlayerStatistics>(new QName("guest_player_3"), FixturePlayerStatistics.class, player);
    }

}