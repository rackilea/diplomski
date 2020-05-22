int dobYear = 21;
int dobMonth = 10;
int dobDay = 22;

LocalDate now = LocalDate.now();
LocalDate dob = now.minusYears(dobYear)
        .minusMonths(dobMonth)
        .minusDays(dobDay);

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
System.out.println(dob.format(formatter));