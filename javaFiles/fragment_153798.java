Handler handler;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    final SubmitButton LoginBtn = findViewById(R.id.login);
    handler = new Handler();
    LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginBtn.setEnabled(false);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        LoginBtn.setEnabled(true);
                        Intent startActivity = new Intent(Login.this, Main_page.class);
                        startActivity(startActivity);
                        finish();
                    }
                }, 3200);
            }

        });
...