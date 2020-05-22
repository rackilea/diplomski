JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        jsonObject.put("key1", "value1");
        jsonObject1.put("key2", "value2");
        jsonObject2.put("key3", "value3");
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);

        //........ Whole Json Array
        System.out.println(jsonArray);


        //To remove 2nd jsonObject (index starts from 0)

        jsonArray.remove(1);


        // Now the array will not have 2nd Object
        System.out.println(jsonArray);