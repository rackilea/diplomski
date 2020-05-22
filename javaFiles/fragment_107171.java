public class Activity1 extends AppCompatActivity {
    private final Double TIP = 10.0;
    private TextView tipView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        setDefaultValues();
    }

    private void setDefaultValues() {
        tipView = findViewById(R.id.tipView);
        tipView.setText(getString(R.string.main_msg_tip, Double.toString(TIP)));
    }

    public void onClickToggleButton(View view) {
        switch (view.getId()) {
            case (R.id.toggleButtonBad):
                tipView.setText(getString(R.string.main_msg_tip, Double.toString(BAD)));
                break;
        }
    }
}