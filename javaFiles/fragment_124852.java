Date start = new Date();
Date end = new Date();

Calendar cStart = Calendar.getInstance(); cStart.setTime(start);
Calendar cEnd = Calendar.getInstance(); cEnd.setTime(end);

while (cStart.before(cEnd)) {

    //add one day to date
    cStart.add(Calendar.DAY_OF_MONTH, 1);

    //do something...
}