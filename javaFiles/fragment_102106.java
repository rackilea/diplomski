public class JsonLogger implements AutoCloseable {

    /**
     * Contains mapping between current thread id and corresponding JsonLogger object
     */
    private static transient ConcurrentHashMap<Long, JsonLogger> loggersMap = new ConcurrentHashMap<>();

    /**
     * Should be configured with special appender pattern, like
     * <encoder>
     *     <pattern>%date{ISO8601} [%-18thread] %-5level %msg %logger{70}%n</pattern>
     * </encoder>
     */
    private transient Logger logger = LoggerFactory.getLogger(getClass());
    private transient static Gson gson = new Gson();


    /**
     * Container that would be serialized to JSON after close and added to JSON log
     */
    private final JsonLogContainer logContainer;

    public JsonLogger (Object request, HttpServletRequest servletRequest) {
        this.logContainer = new JsonLogContainer(gson.toJson(request), servletRequest.getRequestURI());
        // request is started
        loggersMap.put(Thread.currentThread().getId(), this);
    }


    /**
     * @param logString formatted log string, called from custom appender
     */
    public static void putLogInfo (String logString) {
        // find appropriate JsonLogger instance (if any) and append log to it
        JsonLogger jsonLogger = loggersMap.get(Thread.currentThread().getId());
        if ( null != jsonLogger ) {
            jsonLogger.putLogToContainer(logString);
        }
    }

    private void putLogToContainer (String logString) {
        logContainer.putLog(logString);
    }

    @Override
    public void close() throws Exception {
        String log = this.logContainer.getLog(new Date());
        // request is completed
        loggersMap.remove(Thread.currentThread().getId());
        // put record to JSON log
        logger.info(log);
    }

    public void setResult(Object result) {
        logContainer.setResponse(gson.toJson(result));
    }
}