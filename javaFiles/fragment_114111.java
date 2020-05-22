public synchronized void fillRect(SunGraphics2D sg2d,
                                  int x, int y, int width, int height) {
    SunToolkit.awtLock();
    try {
        validateSurface(sg2d);

        XRSurfaceData xrsd = (XRSurfaceData) sg2d.surfaceData;

        x += sg2d.transform.getTranslateX();
        y += sg2d.transform.getTranslateY();

        tileManager.addRect(x, y, width, height);
        tileManager.fillMask(xrsd);

    } finally {
        SunToolkit.awtUnlock();
    }
}