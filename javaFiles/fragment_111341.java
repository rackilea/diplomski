alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int whichButton) {
value = input.getText().toString();

 SharedPreferences sp = getSharedPreference("MyKey",0);
 SharedPreferences.Editor preferencesEditor = sp.edit();
 preferencesEditor.putString("tag", value);
 preferencesEditor.commit();

}
});