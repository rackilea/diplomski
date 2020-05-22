public class Player extends SurfaceView implements Runnable {

Canvas canvas = new Canvas();
SurfaceHolder ourHolder;
Thread ourThread = null;
boolean isRunning = true;
Enemy[] enemy;

public Player(Context context) {
    super(context);
    ourHolder = getHolder();
    ourThread = new Thread(this);
    ourThread.start();
    enemy = new Enemy[3];
    for(int i = 0; i<enemy.length; i++){
        enemy[i] = new Enemy();
    }
}

public void pause() {
    isRunning = false;
    while(true){
    try{
        ourThread.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    break;
}
ourThread = null;
}

public void resume() {
    isRunning = true;
}

public void run() {
    while(isRunning) {
        if(!ourHolder.getSurface().isValid())
            continue;

            canvas = ourHolder.lockCanvas();
            canvas.drawRGB(30, 30, 200);


            for(int i = 0; i<enemy.length; i++){
                enemy[i].draw();
            }

        ourHolder.unlockCanvasAndPost(canvas);
    }           
}
}