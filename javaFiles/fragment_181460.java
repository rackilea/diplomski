//List<SomeBean> are ok in both lists
    fromMap.put("key", new ArrayList<SomeBean>());
    toMap.put("key", new ArrayList<SomeBean>());

    //List<String> are ok in Map<String,List<?>>, not in Map<String, List<SomeBean>>
    fromMap.put("key", new ArrayList<String>()); //DOES NOT COMPILE
    toMap.put("key", new ArrayList<String>());