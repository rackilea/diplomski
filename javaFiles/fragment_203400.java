public final class MyActivity extends AppCompatActivity {

    RelativeLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        parent = (RelativeLayout) findViewById(R.id.parent);
    }

    private void setParentMargin(int left, int top, int right, int bottom) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) parent.getLayoutParams();
        params.setMargins(left, top, right, bottom);
        params.setMarginStart(left);
        params.setMarginEnd(right);
    }

}