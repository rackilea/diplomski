public void SaveText(View view) {
       String saved = text.getText().toString();
       SharedPreferences.Editor editor=prefs.edit();
       editor.put("value",saved);
       editor.commit();

        Toast.makeText(getApplicationContext(), R.string.addedfavs, Toast.LENGTH_SHORT).show();
    }