@Override
protected void onStart() {
    super.onStart();

    if (getIntent().getExtras() != null && getIntent().getExtras().getString("Login") != null && getIntent().getExtras().getString("Login").equals("true")) {
        SharedPreferences tPrefs = getSharedPreferences("UserFormPreferences", MODE_PRIVATE);

        GuestLogin(tPrefs.getString("GuestRoomNumber", ""), tPrefs.getString("GuestSurname", ""));
        getIntent().putExtra("Login", "false");
    }
}