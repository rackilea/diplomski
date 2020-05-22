private final long PERIOD = 1000L; // Adjust to suit timing
private long lastTime = System.currentTimeMillis() - PERIOD;

public void onTick() {//Called every "Tick"
    long thisTime = System.currentTimeMillis();

    if ((thisTime - lastTime) >= PERIOD) {
        lastTime = thisTime;

        if(variable) { //If my variable is true
            boolean = true; //Setting my boolean to true
            /**
            *Doing a bunch of things.
            **/
            //I need a delay for about one second here.
            boolean = false; //Setting my boolean to false;
        }
    }
}