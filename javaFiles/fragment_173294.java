try{

        TreeSet<String> MyTreeSet = new TreeSet<String>();
        MyTreeSet.add("SPAIN");
        MyTreeSet.add("TAIWNA");
        MyTreeSet.add("INDIA");
        MyTreeSet.add("JAPAN");

        System.out.println(MyTreeSet);
        Iterator<String> it= MyTreeSet.iterator();
        JsonObject gsonObj = new JsonObject();
        JSONObject jsonObj = new JSONObject();
        while (it.hasNext()) {
            String country = it.next();
            System.out.println("----country"+country);
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(country);
            jsonArray.put("this");

            jsonObj.put(country, jsonArray);

            JsonArray gsonArray = new JsonArray();

            gsonArray.add(new JsonPrimitive("country"));
            gsonArray.add(new JsonPrimitive("this"));
            gsonObj.add(country, gsonArray);
        }
        System.out.println(gsonObj.toString());
        System.out.println(jsonObj.toString());




    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }