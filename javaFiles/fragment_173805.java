public class GameActivity extends Activity {

RelativeLayout layout;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);
    layout = (RelativeLayout) findViewById(R.id.activity_game);
    layout.setBackgroundResource(R.drawable.image);
}