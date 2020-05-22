public class MainActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

        View view = getWindow().getDecorView().findViewById(android.R.id.content);
    view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent startIntent = new Intent(MainActivity.this, NewActivity.class);
            startActivity(startIntent);
        }
    });

}