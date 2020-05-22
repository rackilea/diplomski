Button highScoreButton1 = (Button) findViewById(R.id.bgc);
SharedPreferences prefs = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
highScoreButton1.setOnClickListener(new OnClickListener() {
    public void onClick (View v) {
        prefs.edit().putInt(BACKGROUND_COLOR, Color.BLACK).commit();             
    }
});