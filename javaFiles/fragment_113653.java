new Thread(new Runnable() {
  public void run() {
    json = getJson();
    // do whatever you need to do after the json is loaded
  }
}).start();