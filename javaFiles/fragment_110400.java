public static void main (String[] args){
    Date d = new Date(9, "June", 8);
    Gregorian g = new Gregorian(d);
    System.out.println(g.getGregorianDateNumber());
    System.out.println(g.getISO8601Date());
    System.out.println(g.leapYear());
}