Button updateTeamName = findViewById(R.id.btnupdateTeamName);
 updateTeamName .setOnClickListener(new View.OnClickListener() {
 @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("team", "United States");
        editor.commit();
    }
 });