public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.testLayout);
        ImageButton b1 = (ImageButton) rl.getChildAt(0);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Image Button 1 clicked",Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton b2 = (ImageButton) rl.getChildAt(1);
        b2.setVisibility(View.VISIBLE);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Image Button 2 clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }
}