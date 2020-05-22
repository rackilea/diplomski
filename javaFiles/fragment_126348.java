final CheckBox checkBox = (CheckBox) findViewById(R.id.add_fb);
SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
final SharedPreferences.Editor editor = preferences.edit();

checkBox.setChecked(preferences.getBoolean("checked",false));

checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { 
    @Override 
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        isCheckedValue = isChecked;
        editor.putBoolean("checked", isChecked);
        editor.apply();
    } 
});