// when starting the app
public static int userScore = 0;
SharedPreferences prefs = getSharedPreferences("level1", Context.MODE_PRIVATE); 
userScore = prefs.getInt("score", 0);
mResult.setText("" + userScore);

public static int scores = 0;
   if (type.get(count[0])) {    
       scores++; 
    }
   if(scores > userScore)
   {
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putInt("score", scores);
        prefsEditor.commit();
   }