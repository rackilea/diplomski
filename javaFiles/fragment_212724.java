public class JobInitializerServlet extends HttpServlet {

/**
 * 
 */
private static final long serialVersionUID = 5102955939315248840L;

/**
 * Application logger to log info, debug, error messages.
 */
private static final Logger APP_LOGGER = Logger.getLogger("appLogger");

/**
 * @see Servlet#init(ServletConfig) Initializes DummyJob
 */
public void init(ServletConfig config) throws ServletException {

    try {
        DummyJob scheduler = new DummyJob();
    } catch (java.text.ParseException e) {
        APP_LOGGER.error(e.getLocalizedMessage(), e);
    } catch (SchedulerException e) {
        APP_LOGGER.error(e.getLocalizedMessage(), e);
    }

}