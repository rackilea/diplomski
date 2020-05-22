@Override
 public void onBackPressed() {

    if (back_pressed + 2000 > System.currentTimeMillis()) {

     android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    else Toast.makeText(getBaseContext(), "click again to leave", Toast.LENGTH_SHORT).show();
    back_pressed = System.currentTimeMillis();
 }