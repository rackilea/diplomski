public class mainClass {
        private long startTime  = System.currentTimeMillis();
        Timer timer  = new Timer(1000, this);
        .....
    }

    public mainClass {
        timer.start();
    }

    //Everytime the button stop clicked, the time will stop and reset to the most current time of the system
    public actionPerformed () {
        timer.stop();
        long endTime    = System.currentTimeMillis();
        long timeInMilliseconds = (endTime - startTime);

        **startTime  = System.currentTimeMillis();** ACCEPTED
    }