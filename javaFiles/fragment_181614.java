try {
    Thread thread = new Thread(new Runnable() {
        public void run() {
            try {
                result = ...make query and verify result
            } catch(Throwable throwable) {
                return false;
            }
        }
    });
    thread.start();
    thread.join(timeout);
    return result;
catch(InterruptedException interruptedexception) {
    return false;
}