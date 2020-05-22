boolean isPrimed = false;
   Canvas canvas;

    @Override
    public void run() {
        while(isRunning) {
            if (!ourHolder.getSurface().isValid())
                continue;

            canvas = ourHolder.lockCanvas();

            if(!isPrimed)
                primeCanvas();

            canvas.drawColor(Color.BLACK);
            canvas.drawRect(0, canvas.getHeight() * 3 / 4, canvas.getWidth(), canvas.getHeight(), buttonPaint);

            for(int i = 0; i < balls.size(); i ++)
                    canvas.drawBitmap(balls.get(i).bitmap, balls.get(i).xCord, balls.get(i).yCord, null);

            Rect r = new Rect();
            p.getTextBounds(score + "", 0, (score + "").length(), r);
            canvas.drawText(score + "", cWidth - r.width() - 20, r.height() + 20, p);

            ourHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void primeCanvas() {
        cHeight = canvas.getHeight();
        cWidth = canvas.getWidth();
        red = getResizedBitmap(red, canvas.getWidth()/12, canvas.getWidth()/12);
        green = getResizedBitmap(green, canvas.getWidth()/12, canvas.getWidth()/12);
        blue  = getResizedBitmap(blue, canvas.getWidth()/12, canvas.getWidth()/12);
        purple = getResizedBitmap(purple, canvas.getWidth()/12, canvas.getWidth()/12);
        white = getResizedBitmap(white, cHeight / 4 * 3, cWidth / 20);
        firstRun = 1;
        totalBalls = 0;
    }