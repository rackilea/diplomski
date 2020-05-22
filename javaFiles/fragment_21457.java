Function<Object, Integer> typeChecking = (input) -> (Integer) Optional.ofNullable(input)
        .filter(Integer.class::isInstance)
        .orElseThrow(IllegalArgumentException::new);

Function<Integer, String> intToString = (num) -> Integer.toString(num);

Function<Object, String> converter = typeChecking.andThen(intToString);