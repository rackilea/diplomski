static class MyHandler extends Handler {
  @Override
  synchronized public void handleMessage(final Message msg) {
    final String myMessage = msg.toString();
    // Do whatever you need to do...
    ...
  }
}

final MyHandler handler = new MyHandler();

final Thread lowp = new Thread(
  new Runnable() { 
    public void run() { 
      // Do whatever you need to do
      ...

      // And call this when you have to do something in the main UI
      final Message mess = new Message();
      mess.obj = "Update the UI!";
      handler.sendMessage(mess);
    }
  });

myLoop.start();