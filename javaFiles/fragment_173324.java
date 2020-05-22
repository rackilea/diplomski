ClockTask ctask = new ClockTask();
Timer timer = new Timer();
timer.schedule(ctask, 0, 1000);
while( true ){
    Thread.sleep(1000);
    serverOutputStream.writeUTF(ctask.date);
       serverOutputStream.flush();
}