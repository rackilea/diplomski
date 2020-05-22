Calendar calendar = Calendar.getInstance();
//Find last Wednesday to act as end date
while(calendar.DAY_OF_WEEK != Calendar.WEDNESDAY){
    calendar.add(Calendar.DAY_OF_MONTH, -1);
}
Date transactionEndDate = calendar.getTime();
//Go back one week from that Wednesday to get start date.
calendar.add(Calendar.DAY_OF_MONTH, -7);
Date transactionStartDate = calendar.getTime();