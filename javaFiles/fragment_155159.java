(new GetVolleyResponse(this)).getResponse(Register.serverUrl + UploadUrl, params, new VolleyCallback() {
            @Override
            public void onSuccessResponse(String result) {
                try {
                    JSONArray jsonArray=new JSONArray(result);
                    JSONObject jsonObject;
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        jsonObject=jsonArray.getJSONObject(i);
                        sp_list.add(jsonObject.getString("name"));
                    }
                    sp_list.add("others");
                    setSpinner();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onErrorResponse(String message) {
               Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
            }
        });