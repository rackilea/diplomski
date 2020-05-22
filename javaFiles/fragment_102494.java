try {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray websites = jsonObject.getJSONArray("website");
        for (int i = 0; i < websites.length(); i++) {
            Log.d("TAG", websites.getString(i));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }