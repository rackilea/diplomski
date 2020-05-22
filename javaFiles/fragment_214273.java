private List<String> countriesList = new ArrayList<String>();

 public List<String> getCountriesList() {

    String[] locales = Locale.getISOCountries();

    for (String countryCode : locales) {

        Locale obj = new Locale("", countryCode);
        countriesList.add(obj.getDisplayCountry(Locale.FRENCH));

    }
Collections.sort(countriesList);
return countriesList;
}