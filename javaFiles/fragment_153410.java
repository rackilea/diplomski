public Airport createAirport(String line) {

    String airport = line.substring(0, line.indexOf(';')).trim();
    line = line.replace(airport + ";", "");
    String country = line.substring(0,line.indexOf(';')).trim();
    line = line.replace(country + ";", "");
    String continent = line.substring(0,line.indexOf(';')).trim();
    line = line.replace(continent + ";", "");
    int length = Integer.parseInt(line.substring(0,line.indexOf(';')).trim());
    return new Airport(airport, country, continent, length);
}