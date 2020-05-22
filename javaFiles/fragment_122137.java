Hashtable<String, String> hashTable = new Hashtable<String, String>();

    Json json = new Json();

    hashTable.put("test", json.toJson(ints) ); //here you are serializing the array

    ... //putting the map into preferences

    String serializedInts = Gdx.app.getPreferences("preferences").getString("test");
    int[] deserializedInts = json.fromJson(int[].class, serializedInts); //you need to pass the class type - be aware of it!