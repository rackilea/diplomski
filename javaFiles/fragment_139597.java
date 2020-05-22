//date to parse
String time = "14:30 Sat 05 May";
time +=  " " + LocalDate.now().getYear();

//specify date format matching above string
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm EEE dd MMM yyyy", Locale.US) ;

//we do not have a year returned but i can make the assumption we use the current year
LocalDateTime formatDateTime = LocalDateTime.parse(time, formatter);