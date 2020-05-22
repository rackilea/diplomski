public static void main(String args[]) throws Exception {
    String a = "2019-05-10";    // ISO date format
    String b = "2019-5-10";     // date format with only a single digit for month
    LocalDate ldA = LocalDate.parse(a, DateTimeFormatter.ISO_DATE);
    LocalDate ldB = LocalDate.parse(b, DateTimeFormatter.ofPattern("yyyy-M-dd"));
    // note the lower case year and day, month stays upper case
    System.out.println(ldA.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日", Locale.JAPAN)));
    System.out.println(ldB.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日", Locale.JAPAN)));
}