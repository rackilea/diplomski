uiHandler.postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent goToMenu = new Intent(getApplicationContext(), MainMenu.class);
        goToMenu.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(goToMenu);
    }
}, 500);