public class MainActivity extends AppCompatActivity {

//Commented code is how it is written to run without problems

//  private MediaPlayer player;

private MediaPlayer player; //Remove the MediaPlayer.create from here

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//        player = MediaPlayer.create(this, R.raw.test);

    setContentView(R.layout.activity_main);

    player = MediaPlayer.create(this, R.raw.test); //and put it here

}