public class Stopwatch {
public long thetime = 0;
public long stoppedtime = 0;
public boolean ticking = false;
public int laps = 0;
public long lastTime = 0;

public static void main(String[] args) {
    Stopwatch s = new Stopwatch();
    Scanner sc = new Scanner(System.in);
    boolean loop = true;
    while (loop = true) {
        System.out.println("1 start 2 is started 3 stop 4 " + "reset 5 check time 6 stop");
        int i = sc.nextInt();
        if (i == 1) {
            s.start();
        } else if (i == 2) {
            System.out.println(s.isStarted());
        } else if (i == 3) {
            s.stop();
        } else if (i == 4) {
            s.reset();
        } else if (i == 5) {
            System.out.println("saved time is " + s.time() + " Seconds");
        } else if (i == 6) {
            System.out.println("closing");
            loop = false;
            break;
        } else {
            System.out.println("invalid");
        }

    }

}

public void start() {

    if (!ticking) {
        thetime = System.currentTimeMillis();
        ticking = true;
    }
}

public boolean isStarted() {
    return ticking;
}

public void stop() {
    if (ticking ) {
        stoppedtime += (System.currentTimeMillis() - thetime);
        ticking = false;
    }
}

public void reset() {
    thetime = System.currentTimeMillis();
    stoppedtime = 0;
}

public double time() {
    double seconds = 1000.000000;
    double currenttime = 0;
    if (ticking) {
        currenttime = (stoppedtime + System.currentTimeMillis() - thetime) / seconds;
        return currenttime;

    } else {
        currenttime = (stoppedtime / seconds);
        return currenttime;
    }

   }
 }