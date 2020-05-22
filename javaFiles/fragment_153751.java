public static int parse(String input) {
    int res = -1;
    switch (input) {
        "TEST1":
            res = TEST1;
            break;
        "TEST2":
            res = TEST2;
            break;
        // ... other options
        default: throw new IllegalArgumentException("unknown string");
    }
}