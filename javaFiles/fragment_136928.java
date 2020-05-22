class MyTask extends TimerTask 
{

    public void run() 
    {
        if(taskHasToEnd) { //taskHasToEnd can be any boolean expression comparing current date with the 'date' at which the task should end
            cancel();
        }
        PlaceWeatherObjectsInSpace();
    }
}