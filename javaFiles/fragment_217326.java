Timer t = new Timer();
t.scheduleAtFixedRate(new TimerTask() {

    @Override
    public void run() {
     // get data from socket and set to text view here
    }

}, 0, 10000 /** milliseconds **/);