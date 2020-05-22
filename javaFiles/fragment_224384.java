Logout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences(login.MyPREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PHONE, "");
        editor.putString(PASS, "");
        editor.apply();
        Intent intent = new Intent(HomeActivity.this,MainActivity.class);
        startActivity(intent);
    }
});