AtomicBoolean paneThreadStarted = new AtomicBoolean(false);

...

natTable.addOverlayPainter(new IOverlayPainter() {

    @Override
    public void paintOverlay(GC gc, ILayer layer) {
        if (this.paneThreadStarted.compareAndSet(false, true)) {
            Display.getDefault().asyncExec(new Runnable() {

                @Override
                public void run() {
                    GC currentGC = new GC(natTable);
                    currentGC.setForeground(GUIHelper.COLOR_WHITE);
                    currentGC.setBackground(GUIHelper.COLOR_BLACK);
                    currentGC.setAlpha(200);
                    currentGC.fillRectangle(0, 0, layer.getWidth(), layer.getHeight());

                    String load = "Loading data ...";
                    Point textExtent = currentGC.textExtent(load);
                    currentGC.drawText(load,
                            layer.getWidth() / 2 - textExtent.x / 2,
                            layer.getHeight() / 2 - textExtent.y / 2,
                            true);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    currentGC.dispose();
                    natTable.redraw();
                }
            });
        }
    }
});