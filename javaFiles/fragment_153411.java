public Airport createAirport(final String line) {
    final String[] fields = line.split(";");
    return new Airport(fields[0].trim(), 
                       fields[1].trim(), 
                       fields[2].trim(), 
                       Integer.parseInt(fields[3].trim()));
}