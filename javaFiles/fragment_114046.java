public void getHairCut(String threadName) {
    enter();
    try {
        if(!barberSleeping) {
            if(freeSeats == 0) {
            System.out.println(threadName + " waiting...");
                freeSeats--;;           
                hairCut.await();
            }
            else {
                System.out.println("waiting room is full " + threadName + " is leaving...");
                return;   // i'm having a problem here,i want the thread to return     from the method and release the monitor's lock to let other threads enter
            }
        }
        // some code
    }
    finally {
        leave(); // this would be called in any case
    }
}