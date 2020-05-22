LocalDate today             = LocalDate.now();
  LocalDate birthday          = LocalDate.of(1982, 9, 26);
  LocalDate thisYearsBirthday = birthday.with(Year.now());

  long age = ChronoUnit.YEARS.between(birthday, today);

  if (thisYearsBirthday.equals(today))
  {
     System.out.println("It is your birthday, and your Age is " + age);
  }
  else
  {
     long daysUntilBirthday = ChronoUnit.DAYS.between(today, thisYearsBirthday);
     System.out.println("Your age is " + age + ". " + daysUntilBirthday + " more days until your birthday!");
  }