String[] namesToLookFor = {"NR"};

    String[] indexArray = {"HELLO","NR"};

    List<String> excludedNames = Arrays.asList(namesToLookFor);

    for(String s : indexArray) {
        if (!excludedNames.contains(s)) {
            System.out.println(s);
        }
    }