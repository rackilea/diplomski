class BallUsingThread implements Runnable{
    int x = 30;
    int y = 30;

    public BallUsingThread(int x, int y){
        this.x  = x;
        this.y = y;
    }
    @Override
    public void run() {
        for(;;){
            x++;