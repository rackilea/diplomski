private int x = -1;
private int y = -1;
private int r = -1;
private int stepsLeft = 300;


@Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    if (x < 0) {                             // generate new circle
        int[] xy = generateXY();
        x = xy[0];
        y = xy[1];
        r = 0;
    }
    if (stepsLeft > 0) {
        canvas.drawColor(Color.WHITE);
        canvas.drawCircle(x, y, r, newPaint); // draw circle with new radius
        r++;                                  // increment radius
        stepsLeft--;                          // decrement steps
        this.invalidate();                    // invalidate the view
    }
}



private int[] generateXY() {
    if (theRandom == null) {
        randomWidthOne =(int) (theRandom.nextInt((int) Math.abs(getWidth()-radiusOne/2)) + radiusOne/2f);
        randomHeightOne = (theRandom.nextInt((int)Math.abs((getHeight()-radiusOne/2 + radiusOne/2f))));
    } else {
        randomWidthOne =(int) (theRandom.nextInt((int) Math.abs(getWidth()-radiusOne/2)) + radiusOne/2f);
        randomHeightOne = (theRandom.nextInt((int)Math.abs((getHeight()-radiusOne/2 + radiusOne/2f))));
    }
    return new int[]{randomWidthOne, randomHeightOne};
}