List<Object> listOfObjects = new ArrayList<Object>();

        HashMap<String, String> hashmap = new HashMap<String,String>();
        hashmap.put("x", "foo");
        hashmap.put("y", "bar");

        listOfObjects.add(hashmap);

        for (int i = 0; i < listOfObjects.size(); i++) {
            System.out.println(((HashMap<String, String>)listOfObjects.get(i)).get("x"));
        }