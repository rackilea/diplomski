Calendar cal = Calendar.getInstance();
int minute = cal.get(Calendar.MINUTE);
if(minute % 15 == 0) 
{
    System.out.println("the current date time is exactly 15 minute");
}