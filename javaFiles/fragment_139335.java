BinaryOperator<String> accumulator = (s1, s2) -> {
    System.out.println("joining \"" + s1 + "\" and \"" + s2 + "\"");
    return s1 + "/" + s2;
};
System.out.println(Stream
                .of("a", "b", "c", "d", "e", "f")
                .parallel()
                .reduce("", accumulator)
);