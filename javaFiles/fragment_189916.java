protected String doInBackground(String... params) {

    int success;
    try {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("bid", bid));

        JSONObject json = jsonParser.makeHttpRequest(
                url_business_detials, "GET", params);

        Log.d("Single Business Details", json.toString());

        success = json.getInt(TAG_SUCCESS);
    } catch (JSONException e) {
        e.printStackTrace();
    }
    return null;
}

@Override
protected void onPostExecute(String result) {               
    if (success == 1) {
        JSONArray businessObj = json.getJSONArray(TAG_BUSINESS); // JSON Array
        JSONObject business = businessObj.getJSONObject(0);

        TextView _bName = (TextView) findViewById(R.id.bnameInf);
        TextView _phone = (TextView) findViewById(R.id.phoneInf);
        TextView _address = (TextView) findViewById(R.id.addressInf);
        TextView _city = (TextView) findViewById(R.id.cityInf);
        TextView _state = (TextView) findViewById(R.id.stateInf);
        TextView _zip = (TextView) findViewById(R.id.zipInf);

        _bName.setText(business.getString(TAG_NAME));
        _phone.setText(business.getString(TAG_PHONE));
        _address.setText(business.getString(TAG_ADDRESS));
        _city.setText(business.getString(TAG_CITY));
        _state.setText(business.getString(TAG_STATE));
        _zip.setText(business.getString(TAG_ZIP));
    }else{
        Toast.makeText(getApplicationContext(), "No Match Returned", Toast.LENGTH_LONG).show();
    }
}