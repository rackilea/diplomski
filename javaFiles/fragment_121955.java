public void convertJSON(JSONObject jsonObject) {
        try {
            JSONObject object = jsonObject.getJSONObject("data");

            Iterator<String> iter = object.keys();
            while (iter.hasNext()) {
                String key = iter.next();
                Object value = object.get(key);

                JSONObject obj2 = object.getJSONObject(key);
                //set key to POJO

                Iterator<String> iter2 = obj2.keys();
                while (iter2.hasNext()) {
                    String key2 = iter2.next();
                    //....so on
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }