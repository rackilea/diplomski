package de.jannik.drltest

import de.jannik.locationrules.VisitedLocation;
import de.jannik.locationrules.User;

global User user;

rule "User has been to Europe"

    when
        exists VisitedLocation(name in ("Berlin", "Paris", "London", "Rome"))
    then
        user.handleVisitedContinent("Europe");
end

rule "User has been to Australia"

    when
        exists VisitedLocation(name in ("Melbourne", "Sydney"))
    then
        user.handleVisitedContinent("Australia");
end

rule "User has been to America"

    when
        exists VisitedLocation(name in ("San Francisco", "New York", "Buenos Aires"))
    then
        user.handleVisitedContinent("America");
end