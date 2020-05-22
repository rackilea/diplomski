TopTerminalsDTO tt = new TopTerminalsDTO();
tt.setDate(new Date());
String strDateFormat = "YYYY-MM-DD HH:mm:ss";
DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
String formattedDate= dateFormat.format(tt.getDate());
System.out.println(formattedDate);