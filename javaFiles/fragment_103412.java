LocalDate birth = LocalDate.parse("2000-02-29");
LocalDate today = LocalDate.now();                             // or pass a timezone as the parameter

LocalDate thisYearBirthday = birth.withYear(today.getYear());  // it gives Feb 28 if birthday is on Feb 29, but the year is not leap.
LocalDate nextBirthday = today.isAfter(thisYearBirthday)
    ? birth.withYear(today.getYear() + 1)
    : thisYearBirthday;

return DAYS.between(today, nextBirthday);                      // import static java.time.temporal.ChronoUnit.DAYS;