SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
    String myDate = "17-04-2011";
    // Create date 17-04-2011 - 00h00
    Date minDate = formatter.parse(myDate);
    // Create date 18-04-2011 - 00h00 
    // -> We take the 1st date and add it 1 day in millisecond thanks to a useful and not so known class
    Date maxDate = new Date(minDate.getTime() + TimeUnit.DAYS.toMillis(1));
    Conjunction and = Restrictions.conjunction();
    // The order date must be >= 17-04-2011 - 00h00
    and.add( Restrictions.ge("orderDate", minDate) );
    // And the order date must be < 18-04-2011 - 00h00
    and.add( Restrictions.lt("orderDate", maxDate) );