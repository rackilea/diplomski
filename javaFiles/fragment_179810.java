public static String randomString(int size, CharSequence validChars) {
    return ThreadLocalRandom.current().ints(size, 0, validChars.length())
        .map(validChars::charAt)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
}
public static String randomString(int minSizeIncl, int maxSizeIncl, CharSequence valid) {
    return randomString(
        ThreadLocalRandom.current().nextInt(minSizeIncl, maxSizeIncl), valid);
}
public static CharSequence asciiLetters() {
    return IntStream.concat(IntStream.rangeClosed('A','Z'), IntStream.rangeClosed('a','z'))
        .collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append);
}
public static CharSequence asciiLetterOrDigit() {
    return IntStream.concat(asciiLetters().chars(),IntStream.rangeClosed('0', '9'))
        .collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append);
}
public static CharSequence asciiCharacters() {
    return IntStream.rangeClosed('!', '~')
        .collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append);
}