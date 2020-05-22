Map<String, Map<String, Integer>> adjMatrix = new HashMap<>();
    Map<String, Integer> aRow = new HashMap<>();
    aRow.put("a", 0);
    aRow.put("b", 1);
    aRow.put("c", 0);
    Map<String, Integer> bRow = new HashMap<>();
    bRow.put("a", 0);
    bRow.put("b", 0);
    bRow.put("c", 1);
    Map<String, Integer> cRow = new HashMap<>();
    cRow.put("a", 0);
    cRow.put("b", 0);
    cRow.put("c", 0);
    adjMatrix.put("a", aRow);
    adjMatrix.put("b", bRow);
    adjMatrix.put("c", cRow);

    System.out.println(adjMatrix.get("a").get("b")); // prints "1"