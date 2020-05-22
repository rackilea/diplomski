private boolean hasAPath(Airport airportA, Airport airportB) {
    Iterator<Flight> aFlights = airportA.getOutgoingFlights();
    while(aFlights.hasNext()) {
        Flight currentFlight = aFlights.next();
        if(currentFlight.getAirportB().equals(airportB)) {         
            return true;            
        }else {             
            return hasAPath(currentFlight.getAirportB(), airportB);
        }

    }

    return false;
}