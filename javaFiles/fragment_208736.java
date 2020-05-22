if(runnable != null) {
  // in this case the user already clicked once at least
  handler.removeCallbacks(runnable);
}

runnable = new Runnable() {
  @Override    
  public void run() {
    //this code will run when user isn't clicking for the time you set before.
  }
};
handler.postDelayed(runnable, DELAY);