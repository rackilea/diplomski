private static final Map <String, Integer> TESTS = new HashMap<>();

static {
    TESTS.put("TEST1", 0x01);
    TESTS.put("TEST2", 0x02);
    // ...
}

public static int parse(String input) {
    if (TESTS.containsKey(input))
        return TESTS.get(input);
    else
        throw new IllegalArgumentException("unknown string");
}