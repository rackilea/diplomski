public class ClockModel implements IModel<String> {
    private long zeroTime;

    public ClockModel( int timeInSecs ) {
        this.zeroTime = System.currentTimeMillis() + (timeInSecs * 1000 );
    }

    public String getObject() {
        return String.valueOf( ( zeroTime - System.currentTimeMillis() ) / 1000 );
    }

}