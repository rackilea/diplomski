private boolean saveCounter(int counter){
    SharedPreferences prefs = getSharedPreferences(prefsFileName, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = prefs.edit();
    editor.putInt(counterKey, counter);
    return editor.commit();
}