public void playerStopped( final int perf ) {
    uiHandler.post( new Runnable() {
        public void run() {
            enableButtons();
            ...
            playerStarted = false;
        }
    });
}