JSONArray choices = new JSONArray();
choices.put("1");
choices.put("2");
choices.put("3");

// Save
SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPreferences.edit();
editor.putString("choices", choices.toString());

// Retrieve
choices = new JSONArray(sharedPreferences.getString("choices", "[]"));