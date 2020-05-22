Do following

    SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
    int oldScore = prefs.getInt("highScore", 0);  
//update score only if new score is higher
    if(newScore > oldScore ){
       Editor edit = prefs.edit();
       edit.putInt("highScore", newScore);
       edit.commit();
    }