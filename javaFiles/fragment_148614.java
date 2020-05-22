for (int i=0;i<jsonArray.length();i++){
                    JSONObject data = jsonArray.getJSONObject(i);

                    message += data.getString("message")+"\n";     
                }
           message_title.setText(message);