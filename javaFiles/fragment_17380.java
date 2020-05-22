try {
                InputStream is;
                //read the whole json file stored in assets
//below is android way of opening file from local resource folder, you can use other means to open
                is = getApplicationContext().getAssets().open("jsonfile.json");
                int size = is.available();

                byte[] buffer = new byte[size];

                is.read(buffer);

                is.close();

                //convert the json file to string
                String bufferString = new String(buffer);

                JSONObject jsonObject;
                JSONArray jsonArray;
                jsonObject = new JSONObject(bufferString);
                jsonArray=jsonObject.getJSONArray("property");
                for (int i=0;i<jsonArray.length();i++){
                    jsonObject = jsonArray.getJSONObject(i);
                    JSONObject s = jsonArray.optJSONObject(i);
                    String s2 = s.getString("value");
                    if(s2.contains("{")){
                        JSONObject jobject = new JSONObject(s2);
                        String valueUnderValue1 = jobject.getString("param_C_1");
                        String valueUnderValue2 = jobject.getString("param_C_2");
                    }
                }


            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                        } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();


            }