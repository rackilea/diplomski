public static void main(String[] args) {
    String source = "Thu, 19 Dec 2019 11:32:04 +0000";
    DateTimeFormatter mFormatter = DateTimeFormatter.RFC_1123_DATE_TIME;

    System.out.println(OffsetDateTime.parse(source, mFormatter));
}