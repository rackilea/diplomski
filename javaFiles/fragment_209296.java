public class MainActivity extends Activity {

    private SmallBang mSmallBang;
    private ImageView ImageButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSmallBang = SmallBang.attach2Window(this);
        ImageButton = (ImageView) findViewById(R.id.imageButton);
    }

    public void onSettingsButtonClick(View view) {
        mSmallBang.bang(view);
        mSmallBang.setmListener(new SmallBangListener() {
            @Override
            public void onAnimationStart() {
            }

            @Override
            public void onAnimationEnd() {
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}