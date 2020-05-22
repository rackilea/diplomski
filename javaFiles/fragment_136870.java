public void run() {
    while (numItersCompleted < maxNumIters) {
        while (guiState == GuiState.PAUSED) {
            try {
                synchronized (lock) {
                    lock.wait(); // problematic line
                }