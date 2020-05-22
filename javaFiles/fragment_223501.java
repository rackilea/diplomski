public synchronized void close() { // added synchornized
    if (!isClosing()) { // read: "if not closing"
        setClosing(true); // set closing so next time close() is called it is a no op
        setOpening(false); // close other loopholes so the state is correct
        System.out.println("GATE: Closing");
        // we're in closing state now, because the close method is almost finished
        // start the actual closing sequence
        Runnable task = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(400);
                    System.out.println("GATE: Closed");
                    setClosed(true);
                    setClosing(false);
                }catch(Exception ex){

                }
            }
        };
        new Thread(task, "closeThread").start();
    }
}