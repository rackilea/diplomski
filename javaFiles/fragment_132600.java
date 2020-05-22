public void schedule() {
    timer.schedule(new MyClass(),Math.round(Math.random()*15000)+5000);
}
class MyClass extends TimerTask {
    public void run() {

    //your code

    //schedule next task;
     schedule();
    }
}