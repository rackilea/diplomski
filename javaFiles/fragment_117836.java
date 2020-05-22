DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
 String temp ="1995-1-13";

 LocalDate date1 = LocalDate.parse(temp, formatter);
 long age = date1.until(LocalDateTime.now(), ChronoUnit.YEARS);
 System.out.println(age);