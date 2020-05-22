Timer timer = new Timer();
TimerTask task = new MyTimerTask();

private class MyTimerTask extends TimerTask {
    public void run() {
        // your code here
    }
}

public void mousePressed(MouseEvent e) {
    timer.scheduleAtFixedRate(task, 0, 1000); // Time is in milliseconds
    // The second parameter is delay before the first run
    // The third is how often to run it
}

public void mouseReleased(MouseEvent e) {
    task.cancel();
    // Will not stop execution of task.run() if it is midway
    // But will guarantee that after this call it runs no more than one more time
}