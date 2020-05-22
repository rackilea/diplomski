int size = sharedPreferences.getInt("size", 0); // if it doesn't exist, get 0
// then save the result like
editor.putString("result" + String.valueOf(size), String.format(stringDate, date) + " - " + text_view5.getText().toString()); // just add index to result
// then increase the size
editor.putInt("size", ++size);
editor.commit();