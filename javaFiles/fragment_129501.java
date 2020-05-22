try {
        JSONArray mJsonArray = new JSONArray(yourJsonString);
        for (int i = 0; i < mJsonArray.length(); i++) {
            User user = new User();
            user.setName(mJsonArray.getJSONObject(i).getString("Name"));
            user.setId(mJsonArray.getJSONObject(i).getString("id"));
            mArrayList.add(user);
        }
    } catch (Exception e) {
        // TODO: handle exception
    }