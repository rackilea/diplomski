public void run() {
    try {
        // open your ports
        while (!Thread.interrupted()) {
            // do stuff
        }
    } finally {
        // close your ports in finally-block
        // so they get closed even on exceptions
    }
}