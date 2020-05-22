@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    final EditText et= (EditText) findViewById(R.id.editText1);
    Handler h = new Handler();

    h.postDelayed(new Runnable() {
        @Override
        public void run() {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(et, InputMethodManager.SHOW_IMPLICIT);
        }

    }, 5000); // delay in milliseconds
}