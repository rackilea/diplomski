int index = 1;
                                   //yyyy, MM, dd, hh, min
LocalDateTime ldt = LocalDateTime.of(2018, 12, 31, 12, 10);
                               //specify custom pattern here
String date = DateTimeFormatter.ofPattern("yyyy.MM.dd.").format(ldt);
String importance = "kozepesen fontos";
String name = "egyik feladat";
String yesNo = "yes";
String formatter = "%-4d| %-12s| %-17s| %-40s| %-5s%n";
//now use System.out.format() to print with pattern specified in 'formatter'
System.out.format(formatter, index, date, importance, name, yesNo);