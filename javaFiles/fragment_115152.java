private void submitContacts() {


    // now here we convert this list array into json string

    Gson gson = new Gson();

    final String newDataArray = gson.toJson(dataArray); // dataarray is list aaray

    final String server_url = "http://www.vvvv.com/Caller/submit_contacts.php"; // url of server check this 100 times it must be working


    // volley

    StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    final String result = response.toString();
                    Log.d("response", "result : " + result); //when response come i will log it
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                    error.getMessage(); // when error come i will log it
                }
            }
    ) {
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> param = new HashMap<String, String>();
            param.put("array", newDataArray); // array is key which we will use on server side

            return param;
        }
    };
    Vconnection.getnInstance(this).addRequestQue(stringRequest); // vConnection i claas which used to connect volley


}