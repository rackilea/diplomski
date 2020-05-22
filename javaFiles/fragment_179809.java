public static String randStringAlpha(int size) {
    return ThreadLocalRandom.current().ints(size, 'A', 'Z'+1)
        .map(c -> ThreadLocalRandom.current().nextBoolean()? c: Character.toLowerCase(c))
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
}