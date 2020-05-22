//
// pseudo code
//
@Component
public class SessionListener implements HttpSessionListener {

    private static final Logger logger = LoggerFactory.getLogger(SessionListener.class);

    @Autowired
    private IWebsocketService   websocketService; // you own service here

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.debug("sessionCreated: {}", se.getSession().getId());

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        String sessionId = se.getSession().getId();
        logger.debug("sessionDestroyed: {}", sessionId);

        websocketService.sendLoginStatus(sessionId, false);
    }

}