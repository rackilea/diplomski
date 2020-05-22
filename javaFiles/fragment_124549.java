public void calcDays(Date start,Date end) {

        Duration d = new Duration(start.getTime(), end.getTime());


        System.out.println("Number of days from dates "+d.getStandardDays());
}