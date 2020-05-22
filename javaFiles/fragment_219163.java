String[] dates = baseString.split("\\. ");

DateTimeFormatter firstFmt = DateTimeFormatter.ofPattern("'Bijgewerkt tot: 'd MMMM uuuu HH:mm", new Locale("nl"));
LocalDateTime first = LocalDateTime.parse(dates[0], firstFmt );

DateTimeFormatter secondFmt = DateTimeFormatter.ofPattern("'Nieuwe bundel: 'd MMMM uuuu", new Locale("nl"));
LocalDate second = LocalDate.parse(dates[1], secondFmt);

System.out.println("First: " + first);
System.out.println("Second: " + second);