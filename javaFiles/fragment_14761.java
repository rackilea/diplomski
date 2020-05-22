public static void main(String[] args) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(""
        + "[yyyy/MM/dd HH:mm:ss.SSSSSS]"
        + "[yyyy-MM-dd HH:mm:ss[.SSS]]"
        + "[ddMMMyyyy:HH:mm:ss.SSS[ Z]]"
    , Locale.ENGLISH);
    System.out.println(LocalDateTime.parse("2016/03/23 22:00:00.256145", formatter));
    System.out.println(LocalDateTime.parse("2016-03-23 22:00:00", formatter));
    System.out.println(LocalDateTime.parse("2016-03-23 22:00:00.123", formatter));
    System.out.println(LocalDateTime.parse("23Mar2016:22:00:00.123", formatter));
    System.out.println(LocalDateTime.parse("23Mar2016:22:00:00.123 -0800", formatter));
}