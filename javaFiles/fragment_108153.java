public Test() {
    // Here we can build map of response methods first, if we like, even though Vectors don't exist yet
    Map<Integer, Function<Vector<String>, Integer>> responseMethods = new HashMap<>();
    responseMethods.put(0, this::response0);
    responseMethods.put(1, this::response1);

    // Now we build the action map of Vectors
    Map<Integer, Supplier<Vector<String>>> actionMethods = new HashMap<>();
    actionMethods.put(0, this::action0);
    actionMethods.put(1, this::action1);

    // At this time, we can now execute the referenced methods to get the actual responses
    Map<Integer, Integer> responses = new HashMap<>();
    for (Integer key : actionMethods.keySet()) {
        Supplier<Vector<String>> actionMethod = actionMethods.get(key);
        Function<Vector<String>, Integer> responseMethod = responseMethods.get(key);
        Vector<String> v = actionMethod.get();
        Integer response = responseMethod.apply(v);
        responses.put(key, response);
    }
}