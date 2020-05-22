public static String updateLongestString(AtomicReference<String> observed, String x) {

    final String longestString = observed.accumulateAndGet(x, maxBy((str1, str2) -> {
        LOGGER.info("Received str1: {}, str2: {}", str1, str2);
        return str1.length() - str2.length();
    }));

    LOGGER.info("New observed: {}.", longestString);

    return longestString;
}