//call this class where you want and get dynamic response 
new AsyncTaskConnection(this).execute("getHomepage",jo.toString());

// and make response fuction

protected void getHomepageResponse(String backresult) {
            try {
// this is your response
                mainObject = new JSONObject(backresult);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }