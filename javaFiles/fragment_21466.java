@Override
   public void onConfigurationChanged(Configuration newConfig) {
       super.onConfigurationChanged(newConfig);

       // Checks the orientation of the screen  
       if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
         rotated = true;
       }
       else {
         rotated = false;
       }
   }