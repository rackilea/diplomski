while(!start.after(end)) 
{
    int year = start.get(Calendar.YEAR);
    int month = start.get(Calendar.MONTH) + 1;
    int day = start.get(Calendar.DAY_OF_MONTH);
    System.out.printf("%d.%d.%d\n", day, month, year);        
    start.add(Calendar.DATE, 1);
}