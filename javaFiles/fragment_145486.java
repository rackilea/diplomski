DrawingThread drawingThread;

private class DrawingThread extends Thread{
    public volatile boolean canDraw = true;

    @Override
    public void run() {
        try {
            while (canDraw) {
                Canvas drawingCanvas = null;
                if (canDraw && holder.getSurface().isValid()) {
                    drawingCanvas = holder.lockCanvas();
                    if (drawingCanvas != null) {
                        drawThisView(drawingCanvas);
                        holder.unlockCanvasAndPost(drawingCanvas);
                    }
                }
            }
        }catch(IllegalStateException e){
            e.printStackTrace();
            canDraw = false;
        }
    }
}


@Override
public void surfaceCreated(SurfaceHolder holder) {
    if(drawingThread != null){
        drawingThread.canDraw = false;
    }
    drawingThread = new DrawingThread();
    drawingThread.start();
}

@Override
public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    if(!drawingThread.canDraw){
        drawingThread = new DrawingThread();
        drawingThread.start();
    }
}

@Override
public void surfaceDestroyed(SurfaceHolder holder) {
    if(drawingThread != null) {
        drawingThread.canDraw = false;
    }
}