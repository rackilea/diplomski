String[] tests = {
        "abcdeb", // "(b)"
        "abcdefg", // "abcdefg"
        "aba", // "(a)"
        "abcdefgxxxhijyyy" // "(y)"
    };
    for (String test : tests) {
        System.out.println(test.replaceAll("(?=.*(.).*\\1).*", "($1)"));
    }