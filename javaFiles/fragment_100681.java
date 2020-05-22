Date today = new Date();
Calendar calendar = Calendar.getInstance();
calendar.setTime(today);

calendar.add(Calendar.MONTH, 1);//Used for finding next month
calendar.set(Calendar.DAY_OF_MONTH, 1);//Setting the Day of month as 1 for starting    
do{
       calendar.add(Calendar.DATE, -1); //In the first case decease day by 1 so get the this months last day
   } while (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
           || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ); // Checking whether the last day is saturday or sunday then it will decrease by 1
    Date lastDayOfMonth = calendar.getTime();
    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    System.out.println("Today: " + sdf.format(today));
    System.out.println("Last Day of Month: " +df.format(lastDayOfMonth));