public void surfaceCreated(SurfaceHolder holder) {
    createSprites();
    gameLoopThread.setRunning(true);
    Thread t = new Thread(gameLoopThread);
    t.start();
}