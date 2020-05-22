DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.US);

// expected output 23...2....29
LocalDate startDate = LocalDate.parse("01/09/1995", f);
LocalDate endDate = LocalDate.parse("30/11/2018", f);
Period period = Period.between(startDate, endDate);