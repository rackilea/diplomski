Canvas canvas = null;

    try {
        canvas = surfaceHolder.lockCanvas();
        synchronized (surfaceHolder) {
            gameSurface.onDraw(canvas);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (canvas != null)
            surfaceHolder.unlockCanvasAndPost(canvas);
    }