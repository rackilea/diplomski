String date = "2019-07-14T18:30:00.000Z";
SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
Date parsedDate = inputFormat.parse(date);
String formattedDate = outputFormat.format(parsedDate);
System.out.println(formattedDate);