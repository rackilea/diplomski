try {
                    JSONObject jsonObject = new JSONObject(buffer.toString());
                    String Dbversion= jsonObject.getString("DBVersion");
                    JSONArray jaGroups = jsonObject.getJSONArray("Groups");
                    for (int i = 0; i < jaGroups.length(); i++) {


                        JSONObject jsObject = jaGroups.getJSONObject(i);
                        String Id = jsObject.getString("Id");
                        String title = jsObject.getString("title");
                        String bg = jsObject.getString("bg");

                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }