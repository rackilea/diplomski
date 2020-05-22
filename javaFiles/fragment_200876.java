JSONRequestService service = new JSONRequestService(getApplicationContext());
service.setParameters(Parameters);
service.postRequest(new Response.Listener<JSONObject>() {
    @Override
    public void onResponse(JSONObject response) {
        try {
            //  response is now available where you want 
        } catch (JSONException e) {
            e.printStackTrace();
        }
    });