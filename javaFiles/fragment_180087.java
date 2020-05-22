public class Tracker {
    private int lastX = Integer.MAX_VALUE;
    private int gateX;
    public Tracker( int gateX ){
        this.gateX = gateX;
    }
    public boolean check( BallView ball ){
        if( lastX == Integer.MAX_VALUE ){
            lastX = ball.getX();
            return;
        }
        int currX = ball.getX();
        return currX == gateX ||
               lastX - gateX > 0 && currX - gateX < 0 ||
               lastX - gateX < 0 && currX - gateX > 0;
    }