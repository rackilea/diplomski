public void test__aaaa(){
        try {
            List<String> test = Arrays.asList("41", "14");

            JSONArray array = new JSONArray(test);

            JSONObject root  = new JSONObject();
            JSONObject data = new JSONObject();
            root.put("data", data);

            data.put("my_array", array);

            assertEquals(root.toString(), "{\"data\":{\"my_array\":[\"41\",\"14\"]}}");

        } catch (JSONException e1) {
        }
    }