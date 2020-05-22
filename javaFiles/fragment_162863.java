public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
            .permitAll().build();

        StrictMode.setThreadPolicy(policy);
        uiHelper = new UiLifecycleHelper(this, callback);
        uiHelper.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        buttonLoginLogout = (LoginButton)findViewById(R.id.authButton);
        buttonLoginLogout.setReadPermissions(Arrays.asList("user_status"));

    }

}