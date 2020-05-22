Map<String, Integer> codec = new HashMap<String, Integer>() {{
        put("a", 0);
        put("b", 1);
        put("c", 2);
    }};
    int adjMatrix[][] = new int[][]{
            {0, 1, 0},
            {0, 0, 1},
            {0, 0, 0}
    };

    System.out.println(adjMatrix[codec.get("a")][codec.get("b")]); //prints "1"