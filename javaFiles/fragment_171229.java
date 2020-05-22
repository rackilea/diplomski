Map<String, Object> testMap = new HashMap<>();
    ArrayList<Integer> testArray = new ArrayList<>();
    testArray.add(1);
    testArray.add(2);
    testArray.add(3);

    testMap.put("test", testArray);

    // works fine, output: [1, 2, 3]
    System.out.println(testMap.get("test"));
    // get 1st element of testArray, error
    if (testMap.get("test") instanceof ArrayList) {
        System.out.println(((ArrayList<Integer>) testMap.get("test")).get(0));
    }