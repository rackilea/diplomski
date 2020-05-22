Button buttonLogin;
EditText textPassword ;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
textPassword = (EditText) findViewById(R.id.editText1);
 buttonLogin = (Button) findViewById(R.id.button1);
    buttonLogin.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
           Toast.makeText(MainActivity.this, textPassword.getText().toString(), Toast.LENGTH_LONG).show();
           }
         });
    textPassword.setOnEditorActionListener(new OnEditorActionListener() {

        @Override
        public boolean onEditorAction(TextView v, int actionId,
                KeyEvent event) {

            @Override
    public boolean onEditorAction(TextView v, int actionId,
            KeyEvent event) {

         if (actionId == EditorInfo.IME_ACTION_DONE) {
             // do your stuff here

            buttonLogin.performClick();
            Log.e("Called","Called OKKKKKK");
            return true;
            }

        Log.e("Called","Called");

        return false;

    }

    });



}