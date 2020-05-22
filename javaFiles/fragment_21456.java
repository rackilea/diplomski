Function<Integer, String> converter = (num) -> Integer.toString(num);

String result = Optional.ofNullable(input)
            .filter(Integer.class::isInstance)
            .map(Integer.class::cast)
            .map(converter).orElseThrow(IllegalArgumentException::new);