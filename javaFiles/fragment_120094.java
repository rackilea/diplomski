Set<String> uniqueString = new HashSet<String>();
    uniqueString.add("test");
    uniqueString.add("test");
    uniqueString.add("count");
    uniqueString.add("check");

    for (String item : uniqueString) {
        System.out.println(item);
    }