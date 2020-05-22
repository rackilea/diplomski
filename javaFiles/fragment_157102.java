public class FifthActivity extends Activity {

            Button button;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fifth_layout);
            Button button = (Button) findViewById(R.id.button10);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                Intent intent = new Intent(FifthActivity.this,SixthActivity.java);
                FifthActivity.this.startActivity(intent);
                }
            });

        }
    }