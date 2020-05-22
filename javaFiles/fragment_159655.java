if(jsonStr != null) {
        try {
            JSONArray photos = new JSONArray(jsonStr);
            photoLast = new String[photos.length()];
            titleLast = new String[photos.length()];
            for (int i = 0; i < photos.length(); i++) {
                JSONObject temp = photos.getJSONObject(i);
                String title = temp.getString("title");
                String thumbNailURL = temp.getString("thumbnailUrl");

                photoLast[i]=thumbNailURL;
                titleLast[i]=title;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }