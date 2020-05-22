public class MainActivity extends Activity {

public TextView player1ScoreView;
public TextView player2ScoreView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    player1ScoreView = (TextView) findViewById(R.id.player1ScoreTextView);
    player2ScoreView = (TextView) findViewById(R.id.player2ScoreTextView);

    GamePlay gamePlay=new GamePlay();
    gamePlay.setViewValue(player2ScoreView);

 }
}

public class GamePlay {
...

public void setViewValue(TextView player2ScoreView)
  {
    player2ScoreView.setText(num.format(player1score));
  }
}