JSONArray jsonArray = myResponse.getJSONArray("items");
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < jsonArray.length(); i++) {
        try {
            JSONObject json = jsonArray.getJSONObject(i);
            JSONObject id = json.getJSONObject("id");

            list.add(id.getString("videoId"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    System.out.println(list);  // [ob1ogBV9_iE, o9vsXyrola4]