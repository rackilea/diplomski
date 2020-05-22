public class MainActivity extends AppCompatActivity {

Button mButton1;
Button mButton2;
Button mButton3;
Button mButton4;

ArrayList<Button> mButtons;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mButton1 = (Button) findViewById(R.id.button1);
    mButton2 = (Button) findViewById(R.id.button2);
    mButton3 = (Button) findViewById(R.id.button3);
    mButton4 = (Button) findViewById(R.id.button4);

    mButtons = new ArrayList<>();
    mButtons.add(mButton1);
    mButtons.add(mButton2);
    mButtons.add(mButton3);

    mButton4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            for(Button button : mButtons){
                button.setText("hello");
            }
        }
    });

}