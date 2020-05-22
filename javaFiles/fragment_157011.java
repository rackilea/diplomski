List<Question> queList = new ArrayList<Question>();
    JSONArray jArray = new JSONArray(responseString);
    int n = jArray.length();
    for (int i = 0; i < n; i++) {
        // GET INDIVIDUAL JSON OBJECT FROM JSON ARRAY
        JSONObject jo = jArray.getJSONObject(i);

        // RETRIEVE EACH JSON OBJECT'S FIELDS
        String id = jo.getString("id");
        String qtext = jo.getString("qtext");
        String opt1 = jo.getString("option1");
        String opt2 = jo.getString("option2");
        String opt3 = jo.getString("option3");
        String opt4 = jo.getString("option4");
        String opt5 = jo.getString("option5");

        Question que = new Question(id, qtext, opt1, opt2, opt3, opt4, opt5);
        queList.add(que);
    }