@Override
    protected void onPause() {
        super.onPause();
    preferences = this.getSharedPreferences(KEY, MODE_PRIVATE);
        editor = preferences.edit();
        editor.putInt(TESTLEVEL, level);
        editor.putFloat(TESTEPFLOAT, ep);
        editor.putFloat(TESTCURRENTEPFLOAT, currentEP);
        editor.apply();
}