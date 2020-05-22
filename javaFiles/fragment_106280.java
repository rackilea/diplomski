public class MainThread extends Thread {

private SurfaceHolder surfaceHolder;
private MainGamePanel gamePanel;
private boolean running;
public boolean pleaseWait = true;
public void setRunning(boolean running) {
    this.running = running;
}

public MainThread(SurfaceHolder surfaceHolder, MainGamePanel gamePanel) {
    super();
    this.surfaceHolder = surfaceHolder;
    this.gamePanel = gamePanel;
}

@Override
public void run() 
{
    Canvas canvas;
    while (running) {
        if(!pleaseWait) {
            canvas = null;
            // try locking the canvas for exclusive pixel editing on the surface
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    // update game state
                    this.gamePanel.update();

                    // draws the canvas on the panel
                    this.gamePanel.onDraw(canvas);
                }
            } finally {
                // in case of an exception the surface is not left in
                // an inconsistent state
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }   // end finally            
        }
        else {
            synchronized (this) {
                try {
                    wait();
                } catch (Exception e) { }
            }
        }
    }
}
}