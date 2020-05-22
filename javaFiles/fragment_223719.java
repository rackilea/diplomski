Scanner reader = new Scanner(System.in);

System.out.print( "Please enter a time: " );
String now = reader.nextLine();
Date date = new SimpleDateFormat("HHmm").parse(now);
SimpleDateFormat format = new SimpleDateFormat("h:mm a");
System.out.println( format.format(date));