String date = "July 2 , 2013";
String year = ""+ date.charAt(date.length()-2) + date.charAt(date.length()-1);
System.out.println(year);

int year2 = Integer.parseInt(year);
System.out.println(year2);