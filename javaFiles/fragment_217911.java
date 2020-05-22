public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

Button one = (Button)this.findViewById(R.id.button1);
final MediaPlayer mp = MediaPlayer.create(this, R.raw.justdoit);
    one.setOnClickListener(new OnClickListener(){

        public void onClick(View v) {
            mp.start();
        }
    });
}}