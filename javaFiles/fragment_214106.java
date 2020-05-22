@Log4j2
public class WitcherDriver extends AbstractModule {


    @Override
    public void configure() {
        requestInjection(this);
    }

    @Inject
    public void startPoller(ClientTrafficCalculator clientTrafficCalculator,
        TaskAllocator taskAllocator, ProxyFleetManager proxyFleetManager) {

        new Thread(proxyFleetManager::collectProxyIps).start();
        new Thread(clientTrafficCalculator::prepareRateLimiterForAllClients).start();
        new Thread(taskAllocator::processPendingRecordsInDDB).start();
        log.info("All threads are started");

        //ProxyFleetManager::collectProxyIps
    }


}