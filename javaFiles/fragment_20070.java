private boolean hasAPath(Airport airportA, Airport airportB) {
    Iterator<Flight> aFlights = airportA.getOutgoingFlights();
    while(aFlights.hasNext()) {
        Flight currentFlight = aFlights.next();
        if(currentFlight.getAirportB().equals(airportB)) {              
            return true;            
        }else {
            if(hasAPath(currentFlight.getAirportB(), airportB)) {
                return true;
            }else {
                continue;
            }
        }

    }
    return false;
}