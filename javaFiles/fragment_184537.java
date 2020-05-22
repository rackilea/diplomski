public static LocalDate dateInput(String userInput) {

    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
    LocalDate date = LocalDate.parse(userInput, dateFormat);


    System.out.println(date);
    return date ;
}