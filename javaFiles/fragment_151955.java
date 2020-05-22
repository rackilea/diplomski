public static void main(String[] args) {
    // example date Strings
    String first = "2020-1-7";
    String second = "1/1/2020";
    // define a formatter that uses several patterns
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("[yyyy-M-d][d/M/yyyy]");
    // parse your dates with it
    LocalDate firstDate = LocalDate.parse(first, dtf);
    LocalDate secondDate = LocalDate.parse(second, dtf);
    // and print them with the ISO formatter
    System.out.println("First: " + firstDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
    System.out.println("Second: " + secondDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
}