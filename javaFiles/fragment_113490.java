else {
    for (Country country : countries) {
        country.setCountry(row.select("td:nth-of-type(1)").text());
        countries.add(country);
    }
}