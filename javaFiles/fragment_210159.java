public class MainActivity extends AppCompatActivity {

    CustomButton buttonTopLeft;
    CustomButton buttonTopRight;

    CustomButton buttonMiddle;
    CustomButton buttonMiddleTopLeft;
    CustomButton getButtonMiddleTopRight;

    CustomButton buttonBottomLeft;
    CustomButton buttonBottomRight;

    CustomButton[] arrayOfCustomButtons;

    ConstraintLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTopLeft = findViewById(R.id.buttonTopLeft);
        buttonTopRight = findViewById(R.id.buttonTopRight);
        buttonBottomLeft = findViewById(R.id.buttonBottomLeft);
        buttonBottomRight = findViewById(R.id.buttonBottomRight);
        buttonMiddle = findViewById(R.id.buttonMiddle);
        buttonMiddleTopLeft = findViewById(R.id.buttonMiddleTopLeft);
        getButtonMiddleTopRight = findViewById(R.id.buttonMiddleTopRight);

        rootView = findViewById(R.id.rootView);

        rootView.post(new Runnable() {
            @Override
            public void run() {
                int rootViewHeight = rootView.getMeasuredHeight();
                Log.i("XXX", "height of rootView is: " + rootViewHeight);
                int segHeight = (int) (rootViewHeight * 0.08f);
                adjustGuideline(R.id.guidelineHorizontalTop, segHeight);
                adjustGuideline(R.id.guidelineHorizontalCenter1, segHeight);
                adjustGuideline(R.id.guidelineHorizontalCenter2, segHeight);
                adjustGuideline(R.id.guidelineHorizontalCenter3, segHeight);
                adjustGuideline(R.id.guidelineHorizontalCenter4, segHeight);
                adjustGuideline(R.id.guidelineHorizontalBottom, segHeight);

                arrayOfCustomButtons = new CustomButton[]{buttonTopLeft, buttonTopRight, buttonBottomLeft,
                    buttonBottomRight, buttonMiddle, buttonMiddleTopLeft, getButtonMiddleTopRight};
                rootView = findViewById(R.id.rootView);
                for (final CustomButton cb : arrayOfCustomButtons) {
                    cb.setClickable(true);
                    cb.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.i("MainActivity", "<<<< width of: " + cb.getTag() + " is: "
                                + cb.getMeasuredWidth());
                        }
                    });
                }
            }
        });
    }

    private void adjustGuideline(int guideLineId, int segHeight) {
        Guideline gl = (Guideline) findViewById(guideLineId);
        ConstraintLayout.LayoutParams lp = ((ConstraintLayout.LayoutParams) gl.getLayoutParams());
        gl.setGuidelineBegin((int) (segHeight * lp.guidePercent / 0.08f));
        gl.setGuidelinePercent(-1f);
    }
}