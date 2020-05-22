public void loadAchievements()  {

     boolean fullLoad = false;  // set to 'true' to reload all achievements (ignoring cache)
     float waitTime = 60.0f;    // seconds to wait for achievements to load before timing out

     // load achievements
     PendingResult p = Games.Achievements.load( playHelper.getApiClient(), fullLoad );
     Achievements.LoadAchievementsResult r = (Achievements.LoadAchievementsResult)p.await( waitTime, TimeUnit.SECONDS );
     int status = r.getStatus().getStatusCode();
     if ( status != GamesStatusCodes.STATUS_OK )  {
        r.release();
        return;           // Error Occured
     }

     // cache the loaded achievements
     AchievementBuffer buf = r.getAchievements();
     int bufSize = buf.getCount();
     for ( int i = 0; i < bufSize; i++ )  {
        Achievement ach = buf.get( i );

        // here you now have access to the achievement's data
        String id = ach.getAchievementId();  // the achievement ID string
        boolean unlocked = ach.getState == Achievement.STATE_UNLOCKED;  // is unlocked
        boolean incremental = ach.getType() == Achievement.TYPE_INCREMENTAL;  // is incremental
        if ( incremental )
           int steps = ach.getCurrentSteps();  // current incremental steps
     }
     buf.close();
     r.release();
  }