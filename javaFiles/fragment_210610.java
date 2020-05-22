String reformat(String dateOfBirth) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd MMM yyyy");
    LocalDate date = LocalDate.parse(dateOfBirth, fomatter);
    return formatter2.print(date);
}