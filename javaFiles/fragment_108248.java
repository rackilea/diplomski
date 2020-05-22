String str = "Fri Mar 1, 2013 4:30 PM";          
SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd, yyyy hh:mm a");
Date date = sdf1.parse(str);
System.out.println("Date Object:" + date);
SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm a");
System.out.println("Formatted Date:" + sdf2.format(date));