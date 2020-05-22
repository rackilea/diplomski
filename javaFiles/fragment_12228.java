public static void main(String[] args) {
    String format = "EEE, d MMM yyyy, HH:mm a";
    DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
    final LocalDate date = formatter.parseLocalDate("Thu, 15 Jan 2015, 9:56 AM");
    System.out.println(date);
}