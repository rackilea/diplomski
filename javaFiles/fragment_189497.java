SimpleDateFormat format = new SimpleDateFormat("d/M/yyyy");  // If this is the right format
Date first = format.parse(tdate);
Date second = format.parse(tdate2);
Date toCheck = format.parse(someDate);
if (toCheck.after(first) && toCheck.before(second)){
    // ...
}