JsonObjectRequest strReq = new JsonObjectRequest(url,
        new Response.Listener<JSONObject>() {

    @Override
    public void onResponse(JSONObject response) {
        // ...
        // Note: you will likely not need this conversion to a JSONObject anymore
        // JSONObject jsonObject = new JSONObject(result); <-- Not needed now
    }
}