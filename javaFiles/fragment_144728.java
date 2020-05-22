Calendar cStart = Calendar.getInstance();
cStart.setTimeInMillis(start);
Calendar cEnd = Calendar.getInstance();
cEnd.setTimeInMillis(end);
Calendar cTest = Calendar.getInstance();
cTest.setTimeInMillis(testtime);

if(cStart.before(cTest) && cEnd.after(cTest)) {
    // testtime is between start and end
}