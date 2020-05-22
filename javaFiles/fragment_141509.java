// convert calendar to ZonedDateTime
ZonedDateTime z = gc.toZonedDateTime();

// print just the LocalDate part
System.out.println("Karfreitag;" + z.minusDays(2).toLocalDate());
System.out.println("Ostermontag;" + z.plusDays(1).toLocalDate());

// get the original calendar back
GregorianCalendar cal = GregorianCalendar.from(z);