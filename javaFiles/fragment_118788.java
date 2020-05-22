String j = "2456606";
int day = Integer.parseInt(j) - x; // x == Jan 1, 1970 on the Gregorian
j = Integer.toString(day);
Date date = new SimpleDateFormat("D").parse(j);
String g = new SimpleDateFormat("dd.MM.yyyy").format(date);
System.out.println(g);