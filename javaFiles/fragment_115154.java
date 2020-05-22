JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, apiURL, null, new Response.Listener<JSONObject>() {
        //Parse data to get temperature
        @Override
        public void onResponse(JSONObject response) {
            try {
                //Get temperature data, format it to 1 decimal place, and output in the text box.
                temp1 = (response.getJSONObject("main").getDouble("temp"));
                String tempFormatted = (getString(R.string.temp_format, temp1));
                tempBox.setText(tempFormatted);
                //get the icon for weather conditions.
                String iconName = response.getJSONArray("weather").getJSONObject(0).getString("icon");
                String imageURL = String.format("http://openweathermap.org/img/w/%1s.png", iconName);
                Glide.with(MainActivity.this).load(imageURL).into(weatherImage);
                textUpdate();
            } catch (JSONException e) {
                //catch errors and toast error message.
                e.printStackTrace();
                Toast errorToast = Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG);
                errorToast.show();
            }
        }
        //Request error handler
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast errorToast = Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG);
            errorToast.show();
        }
    });