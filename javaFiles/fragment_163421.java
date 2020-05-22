JSpinner hour = new JSpinner();
JSpinner min = new JSpinner();

//Your date format
SimpleDateFormat format = new SimpleDateFormat("HHmm");

//Get values from your spinners
String HOUR = (String) hour.getValue();
String MIN = (String) min.getValue();

//Create a date 
Date parsed = format.parse(HOUR + MIN);
java.sql.Time sql = new java.sql.Time(parsed.getTime());

//Insert your date
System.out.println(sql);