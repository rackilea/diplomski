Calendar now = Calendar.getInstance();

now.set(Calendar.DAY_OF_MONTH, 1);


for (int i = 0; i < 10; i++)
{
     now.add(Calendar.MONTH, 1);
     scheduler.scheduleAt(now); // or whatever you are using to schedule
}