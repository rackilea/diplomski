Map<String, Country> countries = new HashMap<String, Country>();
Country country;
//...loop to read the file...
country = countries.get(team);
if (country == null) {
    country = new Country();
}
//add information to country
countries.put(team, country);
//...end loop...