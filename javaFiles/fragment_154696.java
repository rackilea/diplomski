JsonArrayRequest myReq = new JsonArrayRequest(
                                                "http://api.devnews.today",
                                                createMyReqSuccessListener(),
                                                createMyReqErrorListener()){
            };
        queue.add(myReq);
   }
    });
}


private Response.Listener<JSONArray> createMyReqSuccessListener() {
    return new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {


            JSONArray array= null;
            try {
             array = response;


                for(int i=1;i < array.length();i++) {

                    Gson gson = new Gson();
                    Devnews contact = gson.fromJson(String.valueOf(array.getJSONObject(i)), Devnews.class);

                    mTvResult.append(contact.getUrl() + " "+contact.getScore() + " " + contact.getSource()+ " "+ contact.getTitle());

                }

                } catch (JSONException e1) {
                e1.printStackTrace();
            }


        }
    };
}


private Response.ErrorListener createMyReqErrorListener() {
    return new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            mTvResult.setText(error.getMessage());
        }
    };
}