native void XFillRect(long pXSData, long xgc,
                      int x, int y, int w, int h);

public void fillRect(SunGraphics2D sg2d,
                     int x, int y, int width, int height)
{
    SunToolkit.awtLock();
    try {
        long xgc = validate(sg2d);
        XFillRect(sg2d.surfaceData.getNativeOps(), xgc,
                  x+sg2d.transX, y+sg2d.transY, width, height);
    } finally {
        SunToolkit.awtUnlock();
    }
}