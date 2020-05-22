public void paint321(Graphics g) { 
    int hei = this.getHeight(), wid = this.getWidth();

    java.util.Timer timer = new java.util.Timer();
    timer.schedule(new TimerTask() {
         private int counter = 3;

        @Override
        public void run() {               
            if (counter > 0) {
                g.drawString(String.valueOf(counter), wid / 2, hei / 2);
            } else {
                g.drawString("Via!", wid / 2 - 6, hei / 2);
                timer.cancel();
            }

            counter--;
        }
    }, 0L, 1000L);
}