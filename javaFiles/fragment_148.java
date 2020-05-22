List<String> list = new ArrayList <String>();
    list.add("$123");
    list.add("$345");
    list.add("12345");

    for (String s : list) {
        System.out.println(s.replaceAll("^\\$", ""));
    }