//TIMER
public StopWatch(int seconds) {
    initComponents();
    timer = new Timer();
    timer.schedule(new Task(), seconds * 1000);
}