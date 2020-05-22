List<String> countriesList = new ArrayList<String>();



        String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {

            Locale obj = new Locale("", countryCode);
            countriesList.add(obj.getDisplayCountry(Locale.FRENCH));
            Collections.sort(countriesList);
            }
        for(String s:countriesList)
        {
            System.out.println(s);
        }