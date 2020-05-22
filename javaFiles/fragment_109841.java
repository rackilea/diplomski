static String makeString() {
    int targetStringLength = 10;
    return ThreadLocalRandom.current()
        .ints(targetStringLength, 'a', 'z'+1)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
}