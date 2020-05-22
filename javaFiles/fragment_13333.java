for (int i = 1; i < Countries.length(); i++) {
                JSONObject Country = Countries.getJSONObject(i).getJSONObject("country");

                //Details
                String CountryID = Country.getString("id");
                String CountryName = Country.getString("name");
                String CountryImage = Country.getString("image");

                //Hashmap
                HashMap<String, String> TempCountry = new HashMap<>();

                //Details to Hashmap
                TempCountry.put("id", CountryID);
                TempCountry.put("name", CountryName);
                TempCountry.put("image", CountryImage);

                //Hashmap to Countrylist
                CountryList.add(TempCountry);
            }