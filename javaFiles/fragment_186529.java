private void GameOver() {
    gameLoopThread.setRunning(false);
    Context c = getContext();
    c.startActivity(intent); //intent must be declared
    ((Activity) Pruebas.this.getContext()).finish();
}