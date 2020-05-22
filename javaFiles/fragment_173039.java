//HERE YOU ARE GETTING ALL THE VALUES
List<Integer> mapValues = new ArrayList<Integer>(tempMap.values());
HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();

//YOU ARE INSERTING THE VALUES TO A TreeSet WHICH WILL REMOVE DUPLICATES
TreeSet<Integer> sortedSet = new TreeSet<Integer>(mapValues);