public static class LevelPlayer(){

     public int static getLevelPlayer(){

     SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
     int level = preferences.getInt("player_level", 0); //level is the current level of the playe


     return level;
     }

  }