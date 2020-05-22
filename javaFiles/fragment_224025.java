while(!isInterrupted()) {
    try {
       // do something (like play song)
    } catch (InterruptedException e) {
        interrupt();
    }
}