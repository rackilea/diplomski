void changeThreadState() {
    // This is your call back, in controller
}

void threadStart() {
    final X task = new X(); // task creation (variable has to be final)

    final Thread t = new Thread(new Runnable() {

        @Override
        public void run() {
            task.run();
            changeThreadState();
        }
    });

    t.start();
}