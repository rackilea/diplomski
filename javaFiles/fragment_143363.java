// Refresh frame every 200 msec
    while (true) {
        GRFX grfx = new GRFX();
        ecoreFrame.add(grfx);
        ecoreFrame.repaint();
        grfx = null;

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }
    }