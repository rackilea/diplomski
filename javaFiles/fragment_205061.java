ImageButton buttonpaste = (ImageButton) findViewById(R.id.buttonpaste);
SharedPreferences prefs = getSharedPreferences("prefs" Context.MODE_PRIVATE);
boolean isCorrect = getIntent().getBooleanExtra(PhotosActivity.EXTRA_IS_CORRECT, false);
SharedPreferences.Editor e = prefs.edit();

if(isCorrect || prefs.getBoolean(PhotosActivity.EXTRA_IS_CORRECT,false)) {
    buttonpaste.setVisibility(View.VISIBLE);
    e.putBoolean(PhotosActivity.EXTRA_IS_CORRECT, true);
    e.apply();
}