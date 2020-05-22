try {
    c = view.getHolder().lockCanvas();
    synchronized (view.getHolder()) {
        if(c != null)
            view.onDraw(c);
    }
    } finally {
        if (c != null) {
           view.getHolder().unlockCanvasAndPost(c);
        }
}