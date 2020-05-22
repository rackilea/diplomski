Country country = null;
        for (int j = 0; j < myArray.length(); j++) {
              for (int k = 0; k < myArray.getJSONArray(j).length(); k++) {
                String country = myArray.getJSONArray(j).getJSONObject(k).getString(DataConstants.COUNTRY);
                Integer count = myArray.getJSONArray(j).getJSONObject(k).getInt(DataConstants.COUNT);
                country = new Country();
                country.setCode(country);
                country.setCount(count);
                cargo.put(country); //change cargo to take country objects
              }

            }