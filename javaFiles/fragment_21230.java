JSONObject jsonObject = new JSONObject(responseString);

        JSONObject data_json = jsonObject.getJSONObject(“response”);

            status = data_json.getBoolean("Success");

          JSONArray itemInfo = data_json.getJSONArray("items");
           {
                      for (int i = 0; i < itemInfo.length(); i++) {
                        //Do your logic Here

                }
            }