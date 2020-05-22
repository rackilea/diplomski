SharedPreferences prefs = getSharedPreferences("mySHaredpref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        boolean isFirst = prefs.getBoolean("isfirstTime", true);
        if(isFirst) {
            Intent intent = new Intent(this, YourActivityName.class);
            editor.putBoolean(KEY_IS_FIRST_TIME, false);
            editor.commit();
            startActivity(intent);
        }
        else{
           // condition
        }