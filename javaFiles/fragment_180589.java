public void postData(String url,Hashmap data,final VolleyCallback mResultCallback){
        RequestQueue requstQueue = Volley.newRequestQueue(mContext);

        JsonObjectRequest jsonobj = new JsonObjectRequest(Request.Method.POST, url,new JSONObject(data),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if(mResultCallback != null){
                            mResultCallback.notifySuccess(response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if(mResultCallback != null){
                            mResultCallback.notifyError(error);
                        }
                    }
                }
        ){
          //here I want to post data to sever
        };
        requstQueue.add(jsonobj);

    }