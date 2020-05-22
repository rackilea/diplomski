public void run() {
    Toast.makeText(getApplicationContext(), "Timer to Wake", Toast.LENGTH_SHORT).show();
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
}