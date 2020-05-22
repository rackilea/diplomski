cam = Camera.open();
Handler handler = new Handler();
new Thread(new Runnable() {
  public void run() {
    for(int i=0;i<Text.length();i++){
      if(Text.charAt(i)=='.' ||Text.charAt(i)=='·') {
        flash(out_tic);
        continue;
      }
      else if(Text.charAt(i)=='-'){
        flash(3 * out_tic)
        continue;
      }
      // I don't quite understand what this does, but the same principles apply
      else if(Text.charAt(i)=='/'){
        //Warte 2*out_tic lang (1mal wurde schon gewartet)
        if(Text.charAt(i-1)=='/'){

        }
      }
    }
  }
  private void flash(int tic) {
    handler.post(new Runnable() {
      public void run() {
        ledon();
      }
    });
    try {
          Thread.sleep(out_tic);
    } catch (InterruptedException e) {
    }
    handler.post(new Runnable() {
      public void run() {
        ledoff();
      }
    }
  }
});