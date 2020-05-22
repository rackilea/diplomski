public class TimerView extends TextView{

    private Handler handler = new Handler();
    private long startTime;
    private long elapsedTime;
    private final int REFRESH_RATE = 100;
    private String hours,minutes,seconds,milliseconds;
    private long secs,mins,hrs;
    private boolean stopped = false;

    public TimerView(Context context){
        super(context);
        //start();
    }

    public TimerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //start();
    }

    public TimerView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        //start();
    }

    public void start(){
        if(stopped){
            startTime = System.currentTimeMillis() - elapsedTime; 
        }
        else{
            startTime = System.currentTimeMillis();
        }
        handler.removeCallbacks(startTimer);
        handler.postDelayed(startTimer, 0);
    }

    public void stop(){
        handler.removeCallbacks(startTimer);
        stopped = true;
    }

    private Runnable startTimer = new Runnable() {
           public void run() {
               elapsedTime = System.currentTimeMillis() - startTime;
               updateTimer(elapsedTime);
               handler.postDelayed(this,REFRESH_RATE);
           }
        };

    private void updateTimer (float time){
        secs = (long)(time/1000);
        mins = (long)((time/1000)/60);
        hrs = (long)(((time/1000)/60)/60);

        /* Convert the seconds to String 
         * and format to ensure it has
         * a leading zero when required
         */
        secs = secs % 60;
        seconds=String.valueOf(secs);
    if(secs == 0){
        seconds = "00";
    }
    if(secs <10 && secs > 0){
        seconds = "0"+seconds;
    }

        /* Convert the minutes to String and format the String */

    mins = mins % 60;
        minutes=String.valueOf(mins);
    if(mins == 0){
        minutes = "00";
    }
    if(mins <10 && mins > 0){
        minutes = "0"+minutes;
    }

    /* Convert the hours to String and format the String */

    hours=String.valueOf(hrs);
    if(hrs == 0){
        hours = "00";
    }
    if(hrs <10 && hrs > 0){
        hours = "0"+hours;
    }

    /* Although we are not using milliseconds on the timer in this example
     * I included the code in the event that you wanted to include it on your own
     */
    milliseconds = String.valueOf((long)time);
    if(milliseconds.length()==2){
        milliseconds = "0"+milliseconds;
    }
    if(milliseconds.length()<=1){
        milliseconds = "00";
    }
        milliseconds = milliseconds.substring(milliseconds.length()-3, milliseconds.length()-2);

        /* Setting the timer text to the elapsed time */
        this.setText(minutes + ":" + seconds + "." + milliseconds);
        //activity.((TextView)findViewById(R.id.timerMs)).setText("." + milliseconds);
    }
}