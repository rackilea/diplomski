String test = "[[\"test\",\"bob\"],[\"test2\",\"joe\"]]";
    try {
        JSONArray jsonArray = new JSONArray(test);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray array = (JSONArray) jsonArray.get(i);
            for (int j = 0; j < array.length(); j++){
                // print: array.get(j).toString();
            }
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }