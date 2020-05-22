public LocalDate calculateAge() {
    DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate dob = LocalDate.parse(geboortedatum, sdf);
    String dateFormatted = dob.format(sdf);
    System.out.println("dob = " + dateFormatted);
    return dob;
}