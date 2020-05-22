protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_page);
            textPassword = (EditText) findViewById(R.id.editText1);
             buttonLogin = (Button) findViewById(R.id.button1);
            textPassword.setOnEditorActionListener(new OnEditorActionListener() {

                @Override
                public boolean onEditorAction(TextView v, int actionId,
                        KeyEvent event) {
                    try
                    {
                    if ((event.getAction() == KeyEvent.ACTION_DOWN))
                        {
                        buttonLogin.performClick();
                        }
                    }
                    catch ( Exception e) {
                          PrintToast(e.toString());
                    }
                    return false;
                }

            });