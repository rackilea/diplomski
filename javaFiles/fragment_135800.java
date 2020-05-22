public static void main(String[] args) {
    String sExpCompletionDate = "17/01/2019 14:22:11";

    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);

    LocalDateTime dExpCompletionDate = LocalDateTime.parse(sExpCompletionDate, format);
    System.out.println(dExpCompletionDate);
}