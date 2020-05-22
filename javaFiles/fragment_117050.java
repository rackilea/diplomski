Date startDate = (Date) formatter.parse(str_date);
Date endDate = (Date) formatter.parse(end_date);

Calendar cal = Calendar.getInstance();
Calendar cal1 = Calendar.getInstance();
cal.setTime(startDate);
cal1.setTime(endDate);
int i=0; // use this for alternative date print
while (!cal.equals(cal1)) {
    cal.add(Calendar.DATE, 1);
    if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
         System.out.println(cal.get(Calendar.DAY_OF_WEEK)); 
    System.out.println(cal.getTime());

}