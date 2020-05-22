private class AsyncTaskGetMareker extends AsyncTask<String , String, JSONObject> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected JSONObject doInBackground(String... strings) {
            String stationsJsonString = getJSONFromAssets(LoginActivity.this);
            try {
                JSONObject stationsJsonArray = new JSONObject(stationsJsonString);
                return stationsJsonArray;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //This will only happen if an exception is thrown above:
            return null;
        }

        protected void onPostExecute (JSONObject result){
            if (result !=null){
                for (int i =0; i <result.length(); i++){
                    JSONObject jsonObject= null;
                    try {
                        jsonObject= result;
                        String name=jsonObject.getString("store_name");
                        String lat=jsonObject.getString("latitude");
                        String lang=jsonObject.getString("longitude");

                        drawMarker(new LatLng(Double.parseDouble(lat),
                                Double.parseDouble(lang)), name);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }