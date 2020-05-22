while (running) {
    canvas = this.surfaceHolder.lockCanvas();
    this.gameLogic.update();
    this.gameLogic.render(canvas);
    surfaceHolder.unlockCanvasAndPost(canvas);
}

public void render(Canvas canvas) {
    if (!gameOver) {
        ...draw...
    }
}