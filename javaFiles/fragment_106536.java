public static void main(String[] args) throws IOException {
    String str = "2012-02-22T16:46:28.9870216+00:00";
    DateTimeFormatter dtf = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
    LocalDateTime lds = LocalDateTime.parse(str, dtf);
    System.out.println(lds);
    String str2 = "2012-02-22T16:46:28.9970430+00:00";
    String str3 = "2012-02-22T16:46:29.0270266+00:00";
    LocalDateTime lds2 = LocalDateTime.parse(str2, dtf);
    LocalDateTime lds3 = LocalDateTime.parse(str3, dtf);
    System.out.println(lds2.compareTo(lds3));
    System.out.println(lds3.compareTo(lds2));
}