public class Airport {
    private List<Flight> allFlights;

    public List<Flight> getAllFlights() {
        return allFlights;
    }

    public void setAllFlights(List<Flight> allFlights) {
        this.allFlights = allFlights;
    }

    /**
     * Add flights
     * @param flight
     */
    public void addFlights(Flight flight){
        allFlights.add(flight);
    }

    /**
     * Delete flights
     * @param flight
     */
    public void deleteFlight(Flight flight){
        for(Flight eachFlight : allFlights){
            if(eachFlight.equals(flight)){
                allFlights.remove(eachFlight);
                break;
            }
        }
    }

    /**
     * Update specific flight info.
     * 
     * @param flightId
     * @param airplane
     * @param source
     * @param destination
     * @return
     */
    public boolean updateFlight(long flightId, Airplane airplane, String source, String destination){
        boolean isUpdated = false;
        for(Flight eachFlight : allFlights){
            if(eachFlight.getFlightId() == flightId){
                eachFlight.setAirplane(airplane);
                eachFlight.setSourceName(source);
                eachFlight.setDestinationName(destination);
                isUpdated = true;
                break;
            }
        }
        return isUpdated;
    }
}