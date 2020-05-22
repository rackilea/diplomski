@Override
            public void onResponse(String response) {
                try {
                    if(response.isSuccessful){
                    Log.d(TAG, "Response-->" + response);
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("media");
                    Log.d(TAG, "Media Array-->" + jsonArray);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                        ImageGallery imageGallery = new ImageGallery(
                                jsonObject1.getString("file"),
                                jsonObject1.getString("description"),
                                jsonObject.getInt("next"));

                        data_list.add(imageGallery);

                        Log.d(TAG, "Data List in AsyncTask-->" + data_list);
                        }
                       setDataToUI();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }