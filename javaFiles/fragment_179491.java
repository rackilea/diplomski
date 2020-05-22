import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.*;

public class PingServlet extends HttpServlet {
    private static final long EXPIRATION_MILLIS = TimeUnit.SECONDS.toMillis(30);

    private final ConcurrentMap<String, Long> sessionIdToLastPingTime = new ConcurrentHashMap<String, Long>();
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public void init() {
        executor.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                scanForExpiredSessions();
            }
        }, 30, 30, TimeUnit.SECONDS);
    }

    private void scanForExpiredSessions() {
        for (Map.Entry<String, Long> entry : sessionIdToLastPingTime.entrySet()) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }

            final String sessionId = entry.getKey();
            final Long lastPing = entry.getValue();
            if (lastPing == null) {
                // entry was removed from the map by another thread
                continue;
            }
            if (System.currentTimeMillis() > lastPing + EXPIRATION_MILLIS) {
                sessionIdToLastPingTime.remove(sessionId);
                try {
                    expireSession(sessionId);
                } catch (Exception e) {
                    // production code should use a logger
                    e.printStackTrace();
                }
            }
        }
    }

    private void expireSession(String sessionId) {
        // production code should use a logger
        System.out.println("client stopped pinging for session " + sessionId);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String sessionId = req.getSession().getId();
        sessionIdToLastPingTime.put(sessionId, System.currentTimeMillis());
    }

    @Override
    public void destroy() {
        executor.shutdownNow();

        try {
            // this is optional, but may prevent Tomcat from reporting the webapp as a memory-leaker
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {                                                                          
            // production code should use a logger
            System.out.println("interrupted while waiting for executor to shut down");
            Thread.currentThread().interrupt();
        }
    }
}