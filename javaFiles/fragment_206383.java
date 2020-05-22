public static void main(String[] args) throws Exception {
    Long millis0 = 100L; // Sunday, March 31, 2019 5:11:01 PM
    Long millis1 = 100L; // Sunday, May 5, 2019 2:28:12 AM
    Long millis2 = 200L; // Sunday, May 5, 2019 2:28:14.100 AM
    Long millis3 = 200L; // Sunday, May 5, 2019 2:28:14.200 AM

    List<Long> initialTimestamps = Arrays.asList(millis2, millis3, millis0, millis1);
    Set<Long> unique = new HashSet<Long>(initialTimestamps);

    System.out.println(unique);
}