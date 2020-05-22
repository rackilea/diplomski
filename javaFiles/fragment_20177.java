try {
        JSONObject dataToSend = new JSONObject();

        // Profile
        JSONArray jsonArrayProfile = new JSONArray();

        // Post 1
        JSONObject jsonObjectPost1 = new JSONObject();
        jsonObjectPost1.put("fbname", "Think Twice Code Once");
        jsonObjectPost1.put("content", "felling full");
        jsonObjectPost1.put("likes", 1);
        jsonObjectPost1.put("comments", 3);

        // Post 2
        JSONObject jsonObjectPost2 = new JSONObject();
        jsonObjectPost2.put("fbname", "Think Twice Code Once");
        jsonObjectPost2.put("content", "felling full");
        jsonObjectPost2.put("likes", 1);
        jsonObjectPost2.put("comments", 3);

        // Add post1, post2 jsonObject to profile jsonArray
        jsonArrayProfile.put(jsonObjectPost1);
        jsonArrayProfile.put(jsonObjectPost2);

        // Add profile jsonArray to jsonObject
        dataToSend.put("profile", jsonArrayProfile);

        Log.d("SUCCESS", "JSON: " + dataToSend.toString());

    } catch (final JSONException e) {
        Log.e("FAILED", "Json build error: " + e.getMessage());
    }