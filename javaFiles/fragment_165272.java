public static void main(String[] args) {
    class Listener implements ActionListener {
        int tick = 0;
        Timer timer = null;
        public void setTimer(Timer timer) {
            this.timer = timer;
        }
        public void actionPerformed(ActionEvent e) {
            tick++;
            if (tick > 4) {
                timer.stop();
            }
        }
    }
    Listener listener = new Listener();
    Timer timer = new Timer(1000, listener);
    listener.setTimer(timer);
    timer.setInitialDelay(0);
}