private static final ConcurrentHashMap<FlowType, Mapping> mappingsHolder = 
        new ConcurrentHashMap<FlowType, Mapping>();

public static void setMappings(FlowType flowType, Mapping newMapData) {

    mappingsHolder.put(flowType, newMapData);
    hasInitialized.countDown();
}

public static Mapping getFlowMapping(FlowType flowType) {

    try {
        hasInitialized.await();
        return mappingsHolder.get(flowType);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new IllegalStateException(e);
    }
}