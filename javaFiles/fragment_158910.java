public void main() {

    BackgroundServiceThread bst = new BackgroundServiceThread();
    bst.start();

    while (true) {
        //user choose a function
        bst.isPaused = true;
        chosenFunction();
        bst.isPaused = false;
    }
}

private static class BackgroundServiceThread extends Thread {

    volatile boolean isPaused = false;

    @Override
    public void run() {
        while (true) {
            if (!isPaused) {
                //do stuffs;
            }
        }
    }
}

private void chosenFunction() {
    //user choose function
}