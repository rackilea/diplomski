public String listToJsonString(List<StyleAttribute> attrs) {
        JSONObject jObject = new JSONObject();
        try {
            JSONArray jArray = new JSONArray();
            for (MyClass myObject: attrs) {
                JSONObject styleJSON = new JSONObject();
                styleJSON.put("name",myObject.getName());
                styleJSON.put("rollNumber", myObject.getRollNumber());

                jArray.add(styleJSON);
            }
            jObject.put("keyName", jArray);
        } catch (Exception jse) {
        }

        return jObject.toString();
    }