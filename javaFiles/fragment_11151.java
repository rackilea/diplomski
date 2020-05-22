Timer timer = new Timer();
final Callable c = callable;
TimerTask task = new TimerTask() {
    public void run() {
            c.call();
    }
}
t.scheduleAtFixedRate(task, firstExecuteDate, 86400000); // every day