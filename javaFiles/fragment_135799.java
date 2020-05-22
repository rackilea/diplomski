public static void main(String[] args) {
    String sExpCompletionDate = "17/01/2019";

    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);

    LocalDate dExpCompletionDate = LocalDate.parse(sExpCompletionDate, format);
    // Converts LocalDate into LocalDateTime
    LocalDateTime dExpCompletionDate2 = LocalDate.parse(sExpCompletionDate, format).atStartOfDay();
    System.out.println(dExpCompletionDate);
    System.out.println(dExpCompletionDate2);
}