Calendar shiftDay = Calendar.getInstance();
shiftDay.setTime(new Date())
if(shiftDay.get(Calendar.HOUR_OF_DAY) <= 12){
    shiftDay.add(Calendar.DATE, -1);
}
//your date format