try {
    c = view.getHolder().lockCanvas();
    synchronized (view.getHolder()) {
        view.onDraw(c);
    }
    } finally {
        if (c != null) {
           view.getHolder().unlockCanvasAndPost(c);
        }
}