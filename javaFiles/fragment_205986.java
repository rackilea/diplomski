public void restartApp() {
    if (Build.VERSION.SDK_INT >= 11) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recreate();
            }
        });
    }
    else{
    //left out this part because its not relevant
    }
}