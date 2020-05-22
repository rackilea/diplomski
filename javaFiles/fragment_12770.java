JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://alfahd.witorbit.net/api.php?search_member=a&array=1", new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response)
        {
            volleyCallBack.onSuccess(response.toString());
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error)
        {
            JSONObject jsonObject;
            NetworkResponse networkResponse = error.networkResponse;
            if (networkResponse != null && networkResponse.data != null)
            {
                String jsonError = new String(networkResponse.data);
                if(jsonError.contains("500"))
                    createErrorDialog("Something went wrong. Try Later!","");
            }
            volleyCallBack.onFailure(error);
        }
    }) 
//        {
//            @Override
//            public byte[] getBody()
//            {
//                return jsonObject.toString().getBytes();
//            }
//
//            @Override
//            public Map<String, String> getHeaders()
//            {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer " + jwt);
//                params.put("Content-Type", "application/json");
//                return params;
//            }
//        };
    jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
            0,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    requestQueue.add(jsonObjectRequest);