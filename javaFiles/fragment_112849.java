void jsonRequest() {


      URL url = null;
        try {
            url = new URL("https://fcm.googleapis.com/fcm/send");
            try {
                JSONObject data= new JSONObject();
                JSONObject jsonObject=new JSONObject();
                     jsonObject.put("to","someone");
                    data.put("title",title.getText());
                    data.put("messages",message.getText());
                    data.put("body",message.getText());
                    if(spinner.getSelectedItemPosition()==1)data.put("getId",videoListId.getText().toString());
                     else if(spinner.getSelectedItemPosition()==2)data.put("getId",videoId.getText().toString());
                    if(spinner.getSelectedItemPosition()==1)data.put("getSubject",videoListSubject.getText().toString());
                    else if(spinner.getSelectedItemPosition()==2)data.put("getSubject",videoSubject.getText().toString());
                    if(spinner.getSelectedItemPosition()!=0) data.put("getActivity",spinner.getSelectedItem().toString());
                    data.put("img_url",downloadUri.toString());
                    jsonObject.put("data",data);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("https://fcm.googleapis.com/fcm/send", jsonObject, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Toast.makeText(NotificationActivity.this, "worked", Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(NotificationActivity.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {

                        Map<String, String> params = new HashMap<String, String>();
                        params.put("Authorization","key=somekey");
                        params.put("Content-Type","application/json; UTF-8");
                        return params;
                    }
                };
                RequestQueue queue = Volley.newRequestQueue(this);
                queue.add(jsonObjectRequest);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }