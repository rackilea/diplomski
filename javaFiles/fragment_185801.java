@Override
protected void onDraw(Canvas canvas) {
    // TODO Auto-generated method stub
    ballBounds.set(ballX-ballRadius, ballY-ballRadius, ballX+ballRadius,ballY+ballRadius);

canvas.drawOval(ballBounds, paint);
}

public void startLoading(){
    task = new TimerTask() {

        @Override
        public void run() {

            int rnd = (int)(Math.random() * 4);
            switch(rnd){
            case 0:
                paint.setColor(Color.BLUE);
                break;
            case 1: 
                paint.setColor(Color.RED);
                break;
            case 2: 
                paint.setColor(Color.GREEN);
                break;
            case 3:
                paint.setColor(Color.YELLOW);
                break;
            }
            postInvalidate();
        }

    };
    timer = new Timer();
    timer.schedule(task, 0, 3000);

}