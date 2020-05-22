public static void main(String[] args) {

    // set the date
    Calendar cal = Calendar.getInstance();
    cal.set(2011, 10 - 1, 12);

    // "calculate" the start date of the week
    Calendar first = (Calendar) cal.clone();
    first.add(Calendar.DAY_OF_WEEK, 
              first.getFirstDayOfWeek() - first.get(Calendar.DAY_OF_WEEK));

    // and add six days to the end date
    Calendar last = (Calendar) first.clone();
    last.add(Calendar.DAY_OF_YEAR, 6);

    // print the result
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    System.out.println(df.format(first.getTime()) + " -> " + 
                       df.format(last.getTime()));
}