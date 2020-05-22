public class MainActivity extends AppCompatActivity {

private boolean boundToRadioService = false;
private ImageButton imageButton2;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    imageButton2 = (ImageButton) findViewById(R.id.my_button);
    if(savedInstanceState != null){
        boundToRadioService = savedInstanceState.getBoolean("isPlaying", false);
        if(boundToRadioService){
            imageButton2.setImageResource(R.drawable.stop);
        } else {
            imageButton2.setImageResource(R.drawable.play);
        }
    } else {
       // bind to the radio service
       Intent intent = new Intent(this, RadioService.class);
       startService(intent);
       bindService(intent, mConnection, BIND_AUTO_CREATE);
   }
}

@Override
public void onSaveInstanceState(Bundle outState) {
    outState.putBoolean("isPlaying", boundToRadioService);
    super.onSaveInstanceState(outState);
}
public void setupMediaPlayer(View view){
    if (boundToRadioService) {
        boundToRadioService = false;
        imageButton2.setImageResource(R.drawable.play);
        radioService.pause();
    } else {
        boundToRadioService = true;
        imageButton2.setImageResource(R.drawable.stop);
        radioService.play();
     }
   }
}