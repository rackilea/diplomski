public class MatchResult extends Activity {

TextView home, away;

@Override
protected void onCreate(Bundle savedInstanceState) {
// TODO Auto-generated method stub
  super.onCreate(savedInstanceState);
   setContentView(R.layout.match_result);

   resultcounter();

int awayresult = getIntent().getIntExtra(Match.EXTRA_MESSAGE_AWAY, -1);
int homeresult = getIntent().getIntExtra(Match.EXTRA_MESSAGE_HOME, -1);

home.setText(String.valueOf(homeresult));
Log.d("Petter", String.valueOf(homeresult));
}