new Thread(new Runnable() {

  @Override
  public void run() {
      final String str = "Hello World";

      runOnUiThread(new Runnable()
      {
          public void run()
          {
              sayHello(str);
          }
      });
  }

}).start();