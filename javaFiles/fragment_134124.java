import java.util.Timer;
import java.util.TimerTask;

public class Test
{
    private boolean _isOver;
    private int _counter;
    private Timer _timer;
    private String _url; 

    public Test()
    {
        _timer = new Timer("Timer");
    }

    public void Start() //Add parameters here that you want to use in Java
    {
        _counter = 0;
        _isOver = false;
        _url = "";

        TimerTask timerTask = new TimerTask()
        {
            public void run()
            {   
                if (_counter++ == 9)
                {
                    _isOver = true;

                    _timer.cancel();

                    _url = "http://stackoverflow.com/";
                }
            }
        };

        _timer.scheduleAtFixedRate(timerTask, 30, 5000);
    }

    public int getCounter() { return _counter; }
    public boolean getIsOver() { return _isOver; }
    public String getURL() { return _url; }
}