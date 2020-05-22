public class MainActivity extends Activity implements MyAdListener{
private GameView gView; 
AdView adView;
    @Override 
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
 gView = new GameView(this);

AdSize adSize = AdSize.SMART_BANNER;

    DisplayMetrics dm = getResources().getDisplayMetrics();

    double density = dm.density * 160;
    double x = Math.pow(dm.widthPixels / density, 2);
    double y = Math.pow(dm.heightPixels / density, 2);
    double screenInches = Math.sqrt(x + y);

    if (screenInches > 8) { // > 728 X 90
        adSize = AdSize.LEADERBOARD;
    } else if (screenInches > 6) { // > 468 X 60
        adSize = AdSize.MEDIUM_RECTANGLE;
    } else { // > 320 X 50
        adSize = AdSize.BANNER;
    }       
    adView = new AdView(this);
     adView.setAdUnitId("yourAdUnitId"); 
     adView.setAdSize(adSize);
     adView.setVisibility(View.INVISIBLE);
     adView.setBackgroundColor(Color.TRANSPARENT)
    AdRequest adRequest = new AdRequest.Builder().build();
     adView.loadAd(adRequest);     
    RelativeLayout.LayoutParams adViewParams = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT);
    adViewParams.addRule(RelativeLayout.CENTER_HORIZONTAL | RelativeLayout.ALIGN_PARENT_TOP);
    RelativeLayout layout = new RelativeLayout(this);
    layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT));
    layout.addView(gView);
    layout.addView(adView, adViewParams);
    setContentView(layout);
}

@Override
  public void showBannerAd() {
   runOnUiThread(new Runnable() {
   @Override
   public void run(){
    adView.setVisibility(View.VISIBLE);
    }
  });
}
  }



public class GameView extends SurfaceView {

private boolean gameOver;
private Activity mActivity;

public GameView(Activity activity) {
    super(activity);
    myAdListener = (MyAdListener)activity;
    gameOver = false;

}


@Override
protected void onDraw(Canvas canvas) {

    if(!gameOver){

        drawGame(canvas);

    }
    else
    {

        //show admob
       myAdListener.showBannerAd();
        drawGameOver(canvas);

    }

}

public void drawGame(Canvas can){

}

public void drawGameOver(Canvas can){

}

public interface MyAdListener{
public void showBannerAd();
}

}