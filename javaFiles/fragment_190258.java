@Override
public void onBackPressed() {
    //super.onBackPressed();  // don't call the super
    goToHomeScreen();
    startService(new Intent(MainActivity.this, WindowPlayer.class));
}


public void goToHomeScreen() {
    Intent startMain = new Intent(Intent.ACTION_MAIN);
    startMain.addCategory(Intent.CATEGORY_HOME);
    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(startMain);
}