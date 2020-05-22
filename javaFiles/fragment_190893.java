public class DeferringServlet extends HttpServlet {

  private static final Logger logger = Logger.getLogger(DeferringServlet.class);

  private MyApp myApp;
  private Thread appInitializerThread;

  public void init() {
    myApp = new MyApp();
    appInitializerThread = new Thread(new Runnable() {
      public void run() {
        myApp.init();
      }
    });
    appInitializerThread.start();
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    if(myApp.isInitialized()) {
      myApp.doGet(req, resp);
    } else {
      myApp.setStatus(503); //Service unavailable
      myApp.getWriter.println("Please wait.  App is loading");
    }
  }

  public void destroy() {
    if(appInitializerThread.isAlive()) {
      appInitializerThread.interrupt();
    }
    try {
      appInitializerThread.join();
    } catch (InterruptedException ex) {
      logger.warn("Interrupted before app initializer could finish");
    }
  }

}