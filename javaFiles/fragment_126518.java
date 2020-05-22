String res = "[\n" +
            "    {\n" +
            "        \"Class\": \"1\",\n" +
            "        \"school\": \"test\",\n" +
            "        \"description\": \"test\",\n" +
            "        \"student\": [\n" +
            "            \"Student1\",\n" +
            "            \"Student2\"\n" +
            "        ],\n" +
            "        \"qualify\": true,\n" +
            "        \"annualFee\": 3.00\n" +
            "       }\n" +
            "]";

    JSONArray arr = new JSONArray(res);
    for (int i = 0; i < arr.length(); i++) {
        JSONObject block = arr.getJSONObject(i);
        Integer cls = block.getInt("Class");
        System.out.println("cls = " + cls);
        Object school = block.getString("school");
        System.out.println("school = " + school);
        JSONArray students = block.getJSONArray("student");
        System.out.println("student[0] = " + students.get(0));
        System.out.println("student[1] = " + students.get(1));
    }