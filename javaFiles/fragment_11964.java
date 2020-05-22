try {
            response = new JSONObject(con.query("history", parameters));
            JSONArray data = response.getJSONArray("data");
            for(int i = 0; i < data.length(); i++) {
                try {
                    episodeList.add(new Episode((JSONObject) data.get(i)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }