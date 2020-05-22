String[] tests = {
        "ABCDEFG", // true
        "GBADFEC", // true
        "ABCADFG", // false
    };
    for (String test : tests) {
        System.out.format("%s %b%n", test,
            test.matches("(?!.*(.).*\\1)[A-G]{7}")
        );
    }