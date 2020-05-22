client.get("http://localhost/moodle/webservice/rest/server.php?wstoken=0ac06623c66a3dd0e0e431f872a74710&wsfunction=core_user_create_users",params ,new AsyncHttpResponseHandler(){
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        Toast.makeText(getApplicationContext(),  new String(responseBody), Toast.LENGTH_LONG).show();
       }
};