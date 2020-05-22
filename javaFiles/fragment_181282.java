@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final SharedPreferencesManager prefManager = SharedPreferencesManager.getInstance(context);    

    jokesButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            prefManager.increaseClickCount();
        }
    });

    ...
}