import org.joda.time.DateTime;
    import org.joda.time.Months;
    ....
    ....
    DateTime now = new DateTime();
    DateTime then = new DateTime().withDate(2011, 8, 1);
    if(Math.abs(Months.monthsBetween(now, then).getMonths()) > 6){
        System.out.println("6 mo apart!");
        //your logic goes here
    }