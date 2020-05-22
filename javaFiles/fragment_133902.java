public class LoggingClusterListener implements ClusterListener {
    private static final Logger logger = LoggerFactory.getLogger(LoggingClusterListener.class);

    @Override
    public void clusterOpening(final ClusterOpeningEvent clusterOpeningEvent) {
        logger.info("clusterOpening: {}", clusterOpeningEvent.getClusterId().getValue());
    }

    @Override
    public void clusterClosed(final ClusterClosedEvent clusterClosedEvent) {
        logger.info("clusterClosed: {}", clusterClosedEvent.getClusterId().getValue());
    }

    @Override
    public void clusterDescriptionChanged(final ClusterDescriptionChangedEvent event) {
        logger.info("clusterDescriptionChanged: {}", event.getClusterId().getValue());
        for (ServerDescription sd : event.getNewDescription().getServerDescriptions()) {
            logger.info("{} / {} / {} / {}", sd.getType(), sd.getCanonicalAddress(), sd.getState().name());
        }
    }
}