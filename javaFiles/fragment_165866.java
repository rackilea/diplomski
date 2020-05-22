@Override
public boolean onCreateOptionsMenu(Menu menu) {
    //just inflate the actionBar
    getMenuInflater().inflate(R.menu.menu_main, menu);

    //Check if the supportActionBar has been enable
    final ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
        //Start a 2s animation on the actionBar
        new ToolbarAnimator(this, actionBar, Color.RED).start(2 * 1000);
    }
    return true;
}