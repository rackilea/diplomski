public class CartActivity extends AppCompatActivity {

    private CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {

        ContentValues cv;

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            cv = new ContentValues();
            String key;
            int val;

            if (isChecked) {
                key = "col1";
                val = 1;
            } else {
                key = "col2";
                val = 0;
            }

            cv.put(key, val);
            String[] itemId = {String.valueOf(buttonView.getId())};
            Toast.makeText(CartActivity.this,
                    String.format("[%d] %s {%s}", buttonView.getId(), isChecked, cv),
                    Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout view = new LinearLayout(this);
        view.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        ToggleButton[] buttons = new ToggleButton[3];
        for (int i = 0; i < buttons.length; i++) {
            ToggleButton toggle = new ToggleButton(this);

            toggle.setLayoutParams(lp);
            toggle.setId(i);
            toggle.setGravity(Gravity.CENTER);            
            toggle.setTextOn(String.format("On [%d]", i));
            toggle.setTextOff(String.format("Off [%d]", i));
            toggle.setChecked(false);
            toggle.setOnCheckedChangeListener(listener);

            buttons[i] = toggle;
            view.addView(toggle);
        }

        setContentView(view);
    }
}