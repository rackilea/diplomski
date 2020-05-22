public static void main(String[] args) throws Exception {
    Long millis0 = 1554052261000L; // Sunday, March 31, 2019 5:11:01 PM
    Long millis1 = 1557023292000L; // Sunday, May 5, 2019 2:28:12 AM
    Long millis2 = 1557023294100L; // Sunday, May 5, 2019 2:28:14.100 AM
    Long millis3 = 1557023294200L; // Sunday, May 5, 2019 2:28:14.200 AM

    List<Long> initialTimestamps = Arrays.asList(millis2, millis3, millis0, millis1);
    Map<Long, Long> unique = new HashMap<>();

    for (Long timestamp : initialTimestamps) {
        unique.put(timestamp / 1000, timestamp);
    }

    System.out.println(unique.values());
}