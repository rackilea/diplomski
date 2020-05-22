@WebServlet(name = "asyncServlet", value = { "/async" }, asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
    final   PrintWriter out = response.getWriter(); 

        final AsyncContext ctx = req.startAsync();
        ctx.addListener(new AsyncListener() {
            @Override
            public void onTimeout(AsyncEvent arg0) throws IOException {
                System.out.println("onTimeout...");             
            }

            @Override
            public void onStartAsync(AsyncEvent arg0) throws IOException {
                System.out.println("onStartAsync...");              
            }

            @Override
            public void onError(AsyncEvent arg0) throws IOException {
                System.out.println("onError...");           
            }

            @Override
            public void onComplete(AsyncEvent arg0) throws IOException {
                System.out.println("onComplete...");
                out.close();
            }
        });
        ctx.start(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    out.print("<br> Got the request : "+Calendar.getInstance().getTimeInMillis()+" For Async thread :"+Thread.currentThread().getName());
                    out.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                ctx.complete();
            }
        });
        try {
            long time=Calendar.getInstance().getTimeInMillis();
            out.print("<br>Got the request :"+time+" For Original thread completed :"+Thread.currentThread().getName());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}