public void run() {
    while(running) {
        gui.render();
        try { Thread.sleep(10); } catch(InterruptedException e) { /* we tried */}
    }
}