private Timer timer;
...
public void startPaiting() {
    timer = new Timer();
    timer.schedule( new TimerTask(){
        public void run(){
            changeState();
            repaint();
        }
    },0,  10000 ); // 10 s. 
}

public void pause(){
    timer.cancel();
}