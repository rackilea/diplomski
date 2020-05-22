// parsing your string input
// NO!!! timezone is needed in this step because LocalDateTime is just without timezone
String str = "16Jun2015_153556";
DateTimeFormatter formatter = 
    DateTimeFormatter.ofPattern("ddMMMuuuu_HHmmss", Locale.ENGLISH);
LocalDateTime ldt = LocalDateTime.parse(str, formatter);

System.out.println(ldt); // your input as java.time-object: 2015-06-16T15:35:56