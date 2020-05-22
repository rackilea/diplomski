JSONArray array=new JSONArray();
        personList.stream().forEach(element ->
        {
            JSONObject personJson = new JSONObject();
            personJson.put("firstName", element.firstName);
            personJson.put("lastName", element.lastname);
            array.add(personJson);
        });