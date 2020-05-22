Date date=new Date(2013-1900,10,20,8,30);              
SimpleDateFormat dateFormat = new SimpleDateFormat("yyy/MM/dd K mm");
String strFormatDate = dateFormat.format(date);               
Date dtFormatDate = dateFormat.parse(strFormatDate);
System.out.println("Formatted date in String:"+strFormatDate);
System.out.println("Formatted Date:"+dtFormatDate);