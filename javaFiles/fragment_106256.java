private void saveToSharedPreference(String myValue){
        SharedPreferences sharedPre = getSharedPreferences("todoPref",android.content.Context.MODE_PRIVATE);
        Editor editor = sharedPre.edit();
        String key = String.valueOf(Calendar.getInstance().getTimeInMillis());
        editor.putString(key,myValue);
        editor.commit();
    }