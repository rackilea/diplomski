import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/test" }, asyncSupported = true)
public class TestServ extends HttpServlet  implements AsyncServletTaskProcessor{

    /** The exec. */
    private ExecutorService exec;

    public int CALLBACK_TIMEOUT;

    public void init() throws ServletException {
        // read callback timeout form web.xml as init parameter
        CALLBACK_TIMEOUT = Integer.parseInt(getInitParameter("timeout"));
        // read thread pool size form web.xml as init parameter
        int size = Integer.parseInt(getInitParameter("threadpoolsize"));
        exec = Executors.newFixedThreadPool(size);

    }

    @Override
    public void doGet(HttpServletRequest rq, HttpServletResponse rs) {

        rs.setContentType("text/plain");
        rs.setHeader("Access-Control-Allow-Origin", "*");

        //AsyncContext asy = rq.startAsync(rq, rs);
        //asy.start(new Client(asy));

        final AsyncContext asy = rq.startAsync();

        // set the timeout
        asy.setTimeout(CALLBACK_TIMEOUT);

        // attach listener to respond to lifecycle events of this AsyncContext
        asy.addListener(new AsyncListenerImpl(asy));

        // spawn some task in a background thread
        exec.execute(new AsyncServletTaskRunner(asy, this));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    @Override
    public void process(AsyncContext ctx) throws IOException, ServletException {
       //do whatever you want to do as process of each thread
    }
}