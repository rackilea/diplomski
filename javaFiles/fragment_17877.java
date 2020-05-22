boolean TimerRunning = true;

int Timer = 10;

new Thread(new Runnable() {


public void run() {

while(TimerRunning == true) {

Thread.sleep(1000);

if(Timer == 0) {

TimerRunning = false;

}
else {

Timer = Timer - 1;

}

}

}).start();