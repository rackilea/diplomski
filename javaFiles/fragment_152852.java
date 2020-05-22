// "Wrapped" (and thus shared) by task0 and task1 below.
Runnable runnable = new Runnable() {
    @Override
    public void run() {
        System.out.println("task was invoked");
    }
}



Timer timer0 = new Timer();
Task task0 = new Task(runnable);
timer0.schedule(task0, delay);
timer0.cancel();


Task task1 = new Task(runnable);
Timer timer1 = new Timer();
timer1.schedule(task1, delay); // throws an exception if we use task0

Thread.sleep(5000);
timer1.cancel();