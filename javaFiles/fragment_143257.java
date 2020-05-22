handler.postDelayed(new Runnable() {

  public void run() {
    Log.d("MyActivity", "Ding Ding");
     // --> change yourView text data
    //calling postdelayed again
    handler.postDelayed(this, 5000); //added this line
  }
}, 5000);