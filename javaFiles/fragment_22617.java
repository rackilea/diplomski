JSONObject json = new JSONObject(jsonstring);

        status = json.getString("result");

        if (status.equalsIgnoreCase("success")) {


            JSONArray nameArray = json.names();
            JSONArray valArray = json.toJSONArray(nameArray);

            JSONArray valArray1 = valArray.getJSONArray(1);

            valArray1.toString().replace("[", "");
            valArray1.toString().replace("]", "");

            int len = valArray1.length();

            for (int i = 0; i < valArray1.length(); i++) {

                Country country = new Country();
                JSONObject arr = valArray1.getJSONObject(i);

                country.setCountryCode(arr.getString("countryCode"));
                country.setCountryName(arr.getString("countryName"));
                arrCountries.add(country);
            }
        }