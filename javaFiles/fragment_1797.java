public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{

public static final int WIDTH = 856;
public static final int HEIGHT = 480;
public static final int MOVESPEED = -5;
private long smokeStartTime;
private long missileStartTime;
private MainThread thread;
private Background bg;
private Player player;
private ArrayList<Smokepuff> smoke;
private ArrayList<Missile> missiles;
private ArrayList<TopBorder> topborder;
private ArrayList<BotBorder> botborder;
private Random rand = new Random();
private int maxBorderHeight;
private int minBorderHeight;
private boolean topDown = true;
private boolean botDown = true;
private boolean newGameCreated;

public static int HighScore = 0;

public static SharedPreferences prefs;

private String saveScore = "HighScore";

//increase to slow down difficulty progression, decrease to speed up difficulty progression
private int progressDenom = 20;

private Explosion explosion;
private long startReset;
private boolean reset;
private boolean dissapear;
private boolean started;
public static int highScore;
private Context mContext; //Add this line <------



public GamePanel(Context context)
{
    super(context);
    this.mContext = context; //Add this line <------

    //Context pref;
    //SharedPreferences prefs = this.getSharedPreferences("myPrefsKeys", Context.MODE_PRIVATE);
    //Your SharedPreferences are allready defined
    prefs = mContext.getSharedPreferences("myPrefsKeys", Context.MODE_PRIVATE); //Add this line <---
    int oldScore = prefs.getInt("highScore", 0);
    int newScore = Player.getScore()*3;
    //update score only if new score is higher
if(newScore > oldScore ){
   Editor edit = prefs.edit();
   edit.putInt("highScore", newScore);
   edit.commit();
   highScore = newScore;
}

String spackage = "com.knight.myfirstgame";

HighScore = prefs.getInt(saveScore, 0);


    //add the callback to the surfaceholder to intercept events
    getHolder().addCallback(this);

    //make gamePanel focusable so it can handle events
    setFocusable(true);
}