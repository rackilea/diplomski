JSONObject obj = new JSONObject();

obj.put("isboolean",false)

JsonObjectRequest req = new JsonObjectRequest(Constants.URL_PATH, obj,
                new Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {


}, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {