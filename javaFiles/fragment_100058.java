private static FlowSpaceImpl getInstance() {
    if (instance == null) {
        instance = new FlowSpaceImpl();
    }
    return instance;
}