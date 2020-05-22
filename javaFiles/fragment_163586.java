String inputDateString = "01/22/2013";
Calendar calCurr = Calendar.getInstance();
Calendar day = Calendar.getInstance();
day.setTime(new SimpleDateFormat("MM/dd/yyyy").parse(inputDateString));
if(day.after(calCurr)){
               System.out.println("Days Left: " + (day.get(Calendar.DAY_OF_MONTH) -(calCurr.get(Calendar.DAY_OF_MONTH))) );
}