public static void main(String[] args) {
    String ip="2018-05-01T06:47:35.422-05:00";
    ZonedDateTime zdt = ZonedDateTime.parse(ip, DateTimeFormatter.ISO_ZONED_DATE_TIME);

    // my timezone is: -7:00
    System.out.println(zdt.toInstant());                 // 2018-05-01T11:47:35.422Z
    System.out.println(Timestamp.from(zdt.toInstant())); // 2018-05-01 04:47:35.422
}