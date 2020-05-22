//TIMER
public StopWatch(int seconds) {
    initComponents();
    setVisible(true);
    timer = new Timer();
    timer.schedule(new Task(), seconds * 1000);
}