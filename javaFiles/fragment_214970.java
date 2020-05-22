getWidget().getDrawFeaturePoint().eventListeners.addListener(getWidget().getDrawFeaturePoint(), featurePointAddedlistener, EventType.VECTOR_FEATURE_ADDED, new EventHandler() {
    @Override
    public void onHandle(EventObject eventObject) {
        FeatureAddedEvent e = new FeatureAddedEvent(eventObject);
        featurePointAddedlistener.onFeatureAdded(e);
    }
});