public void five(View view) {
        score.setText(String.valueOf(mCounts += 5)+"");

     SharedPreferences.Editor editor = Settings.edit();
        editor.putInt(APP_PREFERENCES_SCORE, mCounts);
        editor.apply();
    }