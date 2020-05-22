String[] tests = {
        "(1,3,6)",
        "(x,y!,a+b=c)",
        "( 1,    3  , 6)",
        "(1,3,6,)",
        "(())",
        "(,)",
        "()",
        "(oh, my, god)",
        "(oh,,my,,god)",
        "([],<>)",
        "(  !!  ,  ??  ,  ++  )",
    };

    for (String test : tests) {
        if (test.matches(pattern)) {
            String[] parts = test
                .replaceAll("^\\(\\s*|\\s*\\)$", "")
                .split("\\s*,\\s*");

            System.out.printf("%s = %s%n",
                test,
                java.util.Arrays.toString(parts)
            );
        } else {
            System.out.println(test + " no match");
        }
    }