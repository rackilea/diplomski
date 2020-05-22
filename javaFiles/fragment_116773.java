public static void main(String[] args) {
    LocalDate birthdate = new LocalDate (1958, 1, 20);
    LocalDate now = new LocalDate();
    Years age = Years.yearsBetween(birthdate, now);
    System.out.println(age.getYears());
}