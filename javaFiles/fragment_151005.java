// Activity with display
public class DisplayActivity extends Activity {
    private TextView display;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // get reference to the TextView
        display = (TextView) findViewById(R.id.textView1);
    }

    public void onResume() {
        super.onResume();
        String inputsValue = getSharedPreferences("myprefs", 0)
                .getString("input", "" /** Default value*/);

        display.setText(inputsValue);
    }
}

// Activity with input
public class InputActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // get reference to EditText and store in SharedPreference
        final EditText input = (EditText) findViewById(R.id.editText1);
        input.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                      getSharedPreferences("myprefs", 0).edit()
                          .putString("input", input.getText().toString()).commit();
                      return true;
                }
                return false;
            }
        });
    }
}