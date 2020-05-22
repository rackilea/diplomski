ArrayList<String> countryName = new ArrayList<String>();

    json_string = loadJSONFromAsset();

    {
        // Locate the WorldPopulation Class
        world = new ArrayList<SignUp>();

        // Create an array to populate the spinner
        worldlist = new ArrayList<String>();



        try {
            // JSON file Assert Folder
            jsonobject = new JSONObject(json_string);
            // Locate the NodeList name
            jsonarray = jsonobject.getJSONArray("countries");
            for (int i = 0; i < jsonarray.length(); i++) {
                jsonobject = jsonarray.getJSONObject(i);

                SignUp worldpop = new SignUp();
                worldpop.setCountry(jsonobject.optString("name"));
                worldpop.setCountry_phone_Code(jsonobject.optString("dial_code"));
                worldpop.setCountry_Code(jsonobject.optString("code"));
                world.add(worldpop);
                // Populate spinner with country names
                worldlist.add(jsonobject.optString("name"));

            }
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
    }

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_dropdown_item, worldlist);

    spinner = (Spinner)findViewById(R.id.spinner);
    spinner.setOnItemSelectedListener(this);
    spinner.setAdapter(adapter);

 }

  public void onItemSelected(AdapterView<?> parent, View view, int position,
                           long id) {


    String CountryPhone = world.get(position).getCountry_phone_Code();
    TextDialCode.setText(CountryPhone);

    country = world.get(position).getCountry();

}