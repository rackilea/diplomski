class ServerRunnable implements Runnable {
  public void run(){}
}

Runnable run = new ServerRunnable();
Thread serverThread = new Thread(run);
serverThread.start();  //#3