Type<Integer> t1 = new Type<Integer>(Integer.class);
    Type<String> t2 = new Type<String>(String.class);

    Map<String, Type<?>> map = new HashMap<>();

    map.put("t1", t1);
    map.put("t2", t2);

    map.get("t1").compare(1, 1); // compiles fine
    map.get("t2").compare("one", "one"); // compiles fine