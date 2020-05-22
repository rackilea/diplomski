String time = "15:30:18";

DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
Date date = sdf.parse(time);

System.out.println("Time: " + sdf.format(date));