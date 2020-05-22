@Override
    public void onClick(View v) {
    if (FirstLayout.getVisibility() == View.INVISIBLE) {
        FirstLayout.setVisibility(View.VISIBLE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("visibility",true).commit();
     }
}