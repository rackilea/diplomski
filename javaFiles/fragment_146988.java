boolean go = false;
while (!go) {
    EventSet eventSet = null;
    try {
        eventSet = eventQueue.remove();
    } catch (InterruptedException e) {
        System.err.println("Something went wrong while waiting for StepEvent");
        e.printStackTrace();
        System.exit(0);
    }
    for (Event e : eventSet) {
        if (e instanceof StepEvent) {
            System.out.println("Step Event!");
            go = true;
        }
    }
}