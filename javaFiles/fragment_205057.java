protected String doInBackground(String... args) {
    // Building Parameters
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add( new BasicNameValuePair( "state", "Pennsylvania" ) );
    // getting JSON string from URL
    String url = "http://www.photosbychristian.com/ems/countys.php";
    JSONObject json = stateParser.makeHttpRequest(url, "GET",
            params);