private ArrayList<String> mCountries = new ArrayList<String>();
    public void getCountryData()
    {
        Locale[] locales = Locale.getAvailableLocales();
         for (Locale locale : locales)
         {
                String country = locale.getDisplayCountry();
                if (country.trim().length()>0 && !mCountries.contains(country))
                {
                    mCountries.add(country);
                }
          }
            Collections.sort(mCountries);
    }