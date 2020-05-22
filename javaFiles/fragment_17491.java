String date="Mar 10, 2016 6:30:00 PM";
SimpleDateFormat spf=new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aaa");
Date newDate=spf.parse(date);
spf= new SimpleDateFormat("dd MMM yyyy");
date = spf.format(newDate);
System.out.println(date);