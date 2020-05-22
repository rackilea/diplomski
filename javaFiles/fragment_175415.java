public void showCroutonMsgThenGoToActivity(String text) {
    Crouton toShow = null;

    LifecycleCallback myCallback = new LifecycleCallback() {
        public void onDisplayed() {
            // do nothing
        }

        // Will be called when your {@link Crouton} has been removed.
        public void onRemoved() {
            skipToNextActivity(MyNewActivity.class);
        }
    };


        //create config 
        Configuration myConfig = new Configuration.Builder().
                setDuration(1000)  
                .build();

        //create style
        Style myStyle = new Style.Builder().setConfiguration(myConfig)
                .setBackgroundColor(R.color.green) //check your color!
                .build();

        //apply my custom stile
        toShow = Crouton.makeText(TestActivity.this, text, myStyle);

    toShow.setLifecycleCallback(myCallback);
    toShow.show();
}


private void skipToNextActivity(Class c) {
    // go to next activity
    Intent i = new Intent(this, c);
    startActivity(i);
    finish();
}