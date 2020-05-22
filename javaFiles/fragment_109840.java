static String makeString() {
    int targetStringLength = 10;
    ThreadLocalRandom random = ThreadLocalRandom.current();
    StringBuilder buffer = new StringBuilder(targetStringLength);
    for (int i = 0; i < targetStringLength; i++) {
        int randomLimitedInt = random.nextInt('a', 'z' + 1);
        buffer.append((char)randomLimitedInt);
    }
    return buffer.toString();
}