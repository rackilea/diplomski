public static void main(String[] args) {
    String dateString = "2020-02-11T17:26:31-05:00";
    OffsetDateTime odt = OffsetDateTime.parse(dateString);

    System.out.println(odt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
}