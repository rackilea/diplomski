HashMap<String, String> map_name_value = new HashMap<String, Stirng>();

for (int i = 0; i <detailsArray.length() ; i++) {

          JSONObject obj = detailsArray.getJSONObject(i)

          listInstituteNames.add(obj.getString("InstituteName"))

          map_name_value.put(obj.getString("InstituteName"),obj.getString("InstituteID"));

    }