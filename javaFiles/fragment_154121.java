public class SuspendOtherRoutePolicy extends RoutePolicySupport implements CamelContextAware {

    private CamelContext camelContext;
    private final Lock lock = new ReentrantLock();
    private String otherRouteId;

    public SuspendOtherRoutePolicy(String otherRouteId) {
        super();
        this.otherRouteId = otherRouteId;
    }

    @Override
    public CamelContext getCamelContext() {
        return camelContext;
    }

    @Override
    public void onStart(Route route) {
        super.onStart(route);
        if (camelContext.getRoute(otherRouteId) == null) {
            throw new IllegalArgumentException("There is no route with the id '" + otherRouteId + "'");
        }
    }

    @Override
    public void setCamelContext(CamelContext context) {
        camelContext = context;
    }

    @Override
    public void onExchangeDone(Route route, Exchange exchange) {
        //log.info("Exchange done on route " + route);
        Route otherRoute = camelContext.getRoute(otherRouteId);
        //log.info("Other route: " + otherRoute);
        throttle(route, otherRoute, exchange);
    }

    protected void throttle(Route route, Route otherRoute, Exchange exchange) {
        // this works the best when this logic is executed when the exchange is done
        Consumer consumer = otherRoute.getConsumer();

        int size = getSize(route, exchange);
        boolean stop = size > 0;
        if (stop) {
            try {
                lock.lock();
                stopConsumer(size, consumer);
            } catch (Exception e) {
                handleException(e);
            } finally {
                lock.unlock();
            }
        }

        // reload size in case a race condition with too many at once being invoked
        // so we need to ensure that we read the most current size and start the consumer if we are already to low
        size = getSize(route, exchange);
        boolean start = size == 0;
        if (start) {
            try {
                lock.lock();
                startConsumer(size, consumer);
            } catch (Exception e) {
                handleException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    private int getSize(Route route, Exchange exchange) {
        return exchange.getContext().getInflightRepository().size(route.getId());
    }

    private void startConsumer(int size, Consumer consumer) throws Exception {
        boolean started = super.startConsumer(consumer);
        if (started) {
            log.info("Resuming the other consumer " + consumer);
        }
    }

    private void stopConsumer(int size, Consumer consumer) throws Exception {
        boolean stopped = super.stopConsumer(consumer);
        if (stopped) {
            log.info("Suspending the other consumer " + consumer);
        }
    }
}