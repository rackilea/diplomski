Stream.of("Hello", "World", "!").forEach(s -> {
    int length = s.length();
    if (length > 1)
    {
        System.out.println(s + ": " + length);
    }
});