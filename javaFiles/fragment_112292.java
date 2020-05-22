handler.postDelayed(new Runnable()
    {
        @Override
        public void run()
        {
            Intent next_scrn = new Intent(SplashScreen.this,MapsActivity.class);
            startActivity(next_scrn);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            SplashScreen.this.finish();
        }
    },2500);