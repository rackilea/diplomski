// Get XML gregorian calendar
XMLGregorianCalendar xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar();
xmlCalendar.setYear(1); // Watch for octal number representations (you had there 0001)
xmlCalendar.setMonth(1);
xmlCalendar.setDay(1);

// Convert to Calendar as it is easier to work with it
Calendar calendar = xmlCalendar.toGregorianCalendar(); // Proleptic for old dates

// Convert to default calendar (will misinterpret proleptic for Julian, but it is a workaround)
Calendar result = Calendar.getInstance();
result.setTimeZone(calendar.getTimeZone());
result.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
result.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
result.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
result.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
result.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
result.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
result.set(Calendar.MILLISECOND, calendar.get(Calendar.MILLISECOND));

System.out.println(result.getTime());