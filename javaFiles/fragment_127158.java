@WebListener
public class RequestListener implements ServletRequestListener {

    private final static Logger LOG = Logger.getLogger(RequestListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        String command = servletRequestEvent.getServletRequest().getParameter("command");
        HttpServletRequest request = (HttpServletRequest)servletRequestEvent.getServletRequest();
        LOG.info("Request initialized. Command: " + command + " " + request.getContextPath());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        String command = servletRequestEvent.getServletRequest().getParameter("command");
        LOG.info("Request destroyed. Command: " + command);
    }

}