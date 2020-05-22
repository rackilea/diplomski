JSONArray jsonArrays=jsonObject.getJSONArray("User");
                for(int i=0;i<jsonArrays.length();i++){
                 JSONObject jsonObject1=jsonArrays.getJSONObject(i);
                    sharedPrefrence_main.setName(jsonObject1.getString("name"));
                    sharedPrefrence_main.setEmail(jsonObject1.getString("email"));
                    sharedPrefrence_main.setMobile_no(jsonObject1.getString("mobile"));

                }