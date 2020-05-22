// in this case, this is for a particular `Airport` instance:
public String getAirportCode() { ... }
public String airportCode;

// and this can be called on the OBJECT
Airport a = new Airport("JFK", 39);
a.getAirportCode();
a.airportCode;