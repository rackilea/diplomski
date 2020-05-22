public class RwdServlet extends HttpServlet {
    private ExecutorService loader;

    @Override
    public void init() throws ServletException {
        super.init();
        loader = Executors.newCachedThreadPool();//or use some other executor, google about difference between them
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Task t=createTask(req); //assume that task implements Runnable or Callable
        loader.submit(t); // submit a task to executor after this line your task will start execution in another thread
    }
    @Override
    public void destroy() {
        loader.shutdown();//this will destroy executor service but before that it will wait until all already submitted tasks will be executed

    }
}