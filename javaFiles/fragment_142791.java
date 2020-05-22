registry.defineParameterType(new ParameterType<>(
            "numbers",
            "\"(1st)"\|\"(first)"\|\"(2nd)"\|\"(second)"\",
            String.class,
            (String arg) -> arg
    ));