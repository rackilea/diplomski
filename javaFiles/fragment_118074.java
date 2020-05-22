Set<String> set = Collections.newSetFromMap(new LinkedHashMap<String, Boolean>(16, 0.75f, true));
    set.add("a");
    set.add("b");
    set.add("c");
    set.add("a");
    set.add("a");
    System.out.println(set);