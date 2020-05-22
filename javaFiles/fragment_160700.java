JSONObject response = new JSONObject(responseStr)
    Iterator<String> keys = response.keys();
        while (keys.hasNext()) {
              String key = keys.next();
              String value = response.getString(key);
       }