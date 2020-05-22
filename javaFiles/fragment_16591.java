int timeTimerPeriod = 60 * 1000; // instance variable
int n = 0;

...

public void timerTwo() {
    System.out.println("Please Enter Run time in minutes as an integer: ");
    Scanner scan = new Scanner(System.in); 
    n = scan.nextInt(); // <-- read n here for first time

    timeTimerTimer.scheduleAtFixedRate(new TimerTask() {...}, timeTimerDelay, timeTimerPeriod * n);
}