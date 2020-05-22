timer.scheduleAtFixedRate(new Cost() {
  @Override
    public void run() {

    super.run();  //Added this call to Cost's original method.

    new Thread(new Runnable() {
        public void run() {
          //your code still here
        }
      }).start();
  }