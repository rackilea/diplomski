SemanticTuple<List<String>, List<List<String>>> object = 
    new SemanticTuple<List<String>, List<List<String>>>(
        "name", 
        Arrays.asList(header.split(headerSplitter)), 
        new ArrayList<List<String>>()
    );