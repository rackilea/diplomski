@Override
public void notifySuccess(String requestType, JSONObject response) {

}

@Override
public void notifySuccess(String requestType, JSONArray response) {
// Here You'll receive Your response as Array. Retrieve Your result from response
}

@Override
public void notifyError(String requestType,VolleyError error) {
    Log.d("GJJJ","GJJJ1");
}