@Override
public void onClick(View v) {
  timer.scheduleAtFixedRate(new TimerTask(){
    @Override
      public void run() {

       Testing.this.runOnUiThread(new Runnable() {
           public void run() {
             //update ui here
              float btLoc = bt.getX();
              bt.setX(btLoc+= 50);
        }
      });
        }
     }, 2000, 2000);

  }
});