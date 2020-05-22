sb.setProgress(0);
sb.setMax(mainPlayer.getDuration());
mainPlayer.start();
timer = new Timer();
MyTask task=new MyTask();
timer.schedule(task,0, 1000);

private class MyTask extends TimerTask {
    public void run() {
        //Your code...
    }
}