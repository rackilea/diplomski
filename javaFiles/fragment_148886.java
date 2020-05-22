Scanner sc = new Scanner(System.in);
String dateFormat = "dd/MM/yyyy";
System.out.println("Please enter a date (" + dateFormat + "): ");
String dateString = sc.next();
Date date = new SimpleDateFormat(dateFormat).parse(dateString);
System.out.println(date.toString());
sc.close();