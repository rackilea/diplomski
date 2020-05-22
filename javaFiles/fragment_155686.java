public static void main(String[] args){
    Calendar now = Calendar.getInstance();

    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    String[] days = new String[7];
    int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 2; //add 2 if your week start on monday
    now.add(Calendar.DAY_OF_MONTH, delta );
    for (int i = 0; i < 7; i++)
    {
        days[i] = format.format(now.getTime());
        now.add(Calendar.DAY_OF_MONTH, 1);
    }
    System.out.println(Arrays.toString(days));

}