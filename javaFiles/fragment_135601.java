SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");      
// from and to dates are from Kolkata's timezone, so the formatter must know that
format.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));      

// dates will be equivalent to this date and time in Kolkata, although
// the date itself doesn't store the timezone in it
Date fromDate = format.parse(from + " 00:00:00");
Date  toDate = format.parse(to + " 23:59:59");

for(Order order : orders){
    Date orderDate = order.getOrderDate();
    // note the extra parenthesis, they make all the difference
    if( (orderDate.after(fromDate) || orderDate.equals(fromDate)) &&
        (orderDate.before(toDate) || orderDate.equals(toDate)) ) {
    ....
    }
}