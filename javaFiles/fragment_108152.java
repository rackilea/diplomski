public Test() {
    // Here we can build map of response methods first, if we like, even though Vectors don't exist yet
    Map<Integer, Function<Vector<String>, Integer>> responseMethods = new HashMap<>();
    responseMethods.put(0, this::response0);
    responseMethods.put(1, this::response1);

    // Now we build the action map of Vectors
    Map<Integer, Vector<String>> actions = new HashMap<>();
    actions.put(0, action0());
    actions.put(1, action1());

    // At this time, we can now execute the referenced methods to get the actual responses
    Map<Integer, Integer> responses = new HashMap<>();
    for (Integer key : actions.keySet()) {
        Vector<String> v = actions.get(key);
        Function<Vector<String>, Integer> responseMethod = responseMethods.get(key);
        Integer response = responseMethod.apply(v);
        responses.put(key, response);
    }
}

public Vector<String> action0() {...}
public Vector<String> action1() {...}

public Integer response0(Vector<String> v) {...}
public Integer response1(Vector<String> v) {...}