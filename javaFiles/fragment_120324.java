SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
Calendar cal = Calendar.getInstance();
Date date=cal.getTime();
System.out.println(sdf.format(date)); //remove line to display only the last 5 days 
for (int i=0;i<5;i++){
   cal.add(Calendar.DAY_OF_MONTH,-1);
   date=cal.getTime();
   System.out.println(sdf.format(date));
}