startButton.addListener(SWT.Selection, new Listener() {

    @Override
    public void handleEvent(Event e) {
        Thread thread = new Thread(new CopyFileTask());
        thread.start();
    }
});