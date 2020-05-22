public class ButtonDemoActivity extends Activity {


    private Button btnDemo;
    private boolean isPink = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_demo_activity);

        btnDemo = (Button) findViewById(R.id.btnDemo);
        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isPink = !isPink;
                int resId = isPink ? R.drawable.pink_button : R.drawable.blue_button;
                btnDemo.setBackgroundResource(resId);
                btnDemo.setText(isPink ? "PINK" : "BLUE");
            }
        });
    }
}