public class MainActivity extends AppCompatActivity 

    {
    MediaPlayer mediaPlayer;//Mediaplayer
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =  findViewById(R.id.start);
        mediaPlayer =  MediaPlayer.create(this,R.raw.music);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        String text = button.getText().toString().trim();
        if (text.equals("start")) 
        {
            mediaPlayer.start(); 
            button.setText("pause");
        } 
        else 
        {
            mediaPlayer.pause(); 
            button.setText("start");
        }

      }
    }
} }