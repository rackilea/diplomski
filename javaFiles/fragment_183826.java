protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Intent intentWithData = getIntent();
    String userNameFromLoginActivity = intentWithData.getStringExtra("keyForUsername");
    String passwordFromLoginActivity = intentWithData.getStringExtra("keyForPassword");
}