private static final int SPLASH_DISPLAY_TIME = 3000;
Handler ur = new Handler();
Runnable yourRunnable = new Runnable() {      
        public void run() {     
                mainIntent = new Intent(SplashScreen.this,MyApp.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish(); 
                overridePendingTransition(R.anim.fadein,
                        R.anim.fadeout);    
        }
};
ur.postDelayed(yourRunnable, SPLASH_DISPLAY_TIME);