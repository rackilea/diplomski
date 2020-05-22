public static void main(String[] args) {

    BlockingQueue<Integer> edgeAlerts = new ArrayBlockingQueue<Integer>(2);
    clockThread = new ClockThread("clockThread", 1, edgeAlerts);
    clockThread.start();
    boolean isInterrupted = false;

    while(!isInterrupted) {
        try {
            Integer edgeValue = edgeAlerts.take();
            if (edgeValue == 1) {
                System.out.println("Executing instruction");
                // Perform the instruction
            }
        } catch (InterruptedException e) {
            isInterrupted = true;
        }
    }
}