SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
SharedPreferences.Editor editor = sp.edit();
if(score > high_score)
{
    editor.putInt("high_score", score);
    editor.apply();  /* Edit the value here*/
}