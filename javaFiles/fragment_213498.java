@Component
public class InMemoryTraceRepository implements TraceRepository {

    private static final Logger HTTP_LOGGER = LoggerFactory.getLogger("http-logger");

    // For security matters it's better to not expose Traces on HTTP
    @Override
    public List<Trace> findAll() {
        return null;
    }

    @Override
    public void add(Map<String, Object> map) {
        Trace trace = new Trace(new Date(), map);
        String traceInfo = trace.getInfo().toString();
        HTTP_LOGGER.info(traceInfo);
    }
}