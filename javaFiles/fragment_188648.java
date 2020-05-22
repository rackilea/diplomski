@WebServlet("/foo" asyncSupported=true)
   public class MyServlet extends HttpServlet {
        public void doGet(HttpServletRequest req, HttpServletResponse res) {
            ...
            AsyncContext aCtx = request.startAsync(req, res);
            ScheduledThreadPoolExecutor executor = new ThreadPoolExecutor(10);
            executor.execute(new AsyncWebService(aCtx));
        }
   }

   public class AsyncWebService implements Runnable {
        AsyncContext ctx;
        public AsyncWebService(AsyncContext ctx) {
            this.ctx = ctx;
        }
        public void run() {
            // Invoke web service and save result in request attribute
            // Dispatch the request to render the result to a JSP.
            ctx.dispatch("/render.jsp");
   }
}