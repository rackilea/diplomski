Object someObject = new Object();
    Map<String,Object> map = new HashMap<String,Object>();
    map.put("key1", someObject);
    System.out.println(map.get("key1") == someObject); // prints "true"

    someObject = "something else";
    System.out.println(map.get("key1") == someObject); // prints "false"