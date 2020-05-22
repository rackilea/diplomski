int millis = 500;
new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
            SplashScreenActivity.this.finish();
        }
    }, millis);