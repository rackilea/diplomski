// on init
    long beginTime, timeTaken;
    beginTime = System.nanoTime();


    public void render(Canvas canvas) {

            canvas.drawColor(Color.BLACK);

            droid.draw(canvas);

            if(timeTaken > 15000000000L)
            droid2.draw(canvas);

            if(timeTaken > 30000000000L) // both in nanoseconds
            droid3.draw(canvas);

            timeTaken = System.nanoTime() - beginTime;

        }