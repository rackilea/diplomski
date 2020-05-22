public class MainActivity extends Activity {

    private SmallBang mSmallBang;
    private ImageView ImageButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSmallBang = SmallBang.attach2Window(this);

        ImageButton = (ImageView) findViewById(R.id.imageButton);
        ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSmallBang.bang(v);
                mSmallBang.setmListener(new SmallBangListener() {
                    @Override
                    public void onAnimationStart() {
                    }

                    @Override
                    public void onAnimationEnd() {

                    }
                });
            }
        });
    }
}