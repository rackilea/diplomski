try {
            JSONArray jsonArray = new JSONArray(data);
            int length = jsonArray.length();

            for (int i = 1; i < length; i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                Log.i(TAG, i + " username: " + obj.getString("username"));
                Log.i(TAG, i + " photo: " + obj.getString("photo"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }