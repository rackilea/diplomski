new Handler().postDelayed(new Runnable() {

        /*
         * Showing splash screen with a timer. This will be useful when you
         * want to show case your app logo / company
         */

        @Override
        public void run() {
            Intent mainIntent = new Intent(SplashScreenClass.this, Homescreen.class);
            startActivity(mainIntent);
            finish();
            // close this activity
        }
    }, 3000);