public Country findByCode(String cd) throws SQLException {
List<Country> countries= findCountries("SELECT code, iso3, name, 
continent, region, surfacearea, population, 
latitude, longitude, capital, governmentform FROM country WHERE code = 
'" + code + "'");
}
if(!countries.isEmpty()) {
return countries.get(0);
}
return null;
}