@Override
         protected void onPostExecute(JSONObject json)
         {
          super.onPostExecute(json);

             try
             {
                    // Getting JSON Array
                   // JSONObject jsonObject = user.getJSONObject(0);
                 json.put(KEY_REQUEST_ID, RequestId);
                 json.put(KEY_REQUEST_CODE, RequestCode);
                 json.put(KEY_CHANNEL_ID, stringChannelId);
                 json.put(KEY_IP_ADDRESS, str_Device_IP_Address);
                 json.put(KEY_USERNAME, strUserName);
                 json.put(KEY_PASSWORD, strPassWord);

                 .......................................
                 } 

             catch (JSONException e)

             {
                e.printStackTrace();
            } 

             catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
              pDialog.dismiss(); //dissmiss the progress dialog after sending response.

         }