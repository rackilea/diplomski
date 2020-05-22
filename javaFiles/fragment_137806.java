public class ThreadHandler extends Thread {
      private ArrayList<ServerThread> serverThreads = new ArrayList<ServerThread>();
      public void run() {
            while (!isInterrupted()) { //You should handle interrupts in some way, so that the thread won't keep on forever if you exit the app.
                  (Code...)
                  ServerThread thread = new ServerThread(serverSocket.accept());
                  serverThreads.add(thread);
                  thread.start();
            }
      }
      public void doSomethingOnAllThreads() {
            for (ServerThread serverThread : serverThreads) {
                  serverThread.otherMethod();
            }
      }
}