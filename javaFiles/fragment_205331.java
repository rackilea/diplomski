JSONObject jsonObj = new JSONObject("jsonResponse");
            JSONArray item = jsonObj.getJSONArray("data");
            if (item.length() != 0) {
                for (int i = 0; i < item.length(); i++) {
                   JSONObject json = item.getJSONObject(i);
                    String fromVersion = json.optString("name");  
                              or                  
                    String fromVersion = json.getString("name");  
                }
            }