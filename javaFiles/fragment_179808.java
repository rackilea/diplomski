public static String randStringAlpha(int size) {
    return ThreadLocalRandom.current().ints('A', 'z'+1)
        .filter(Character::isLetter)
        .limit(size)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
}