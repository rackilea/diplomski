public class FlowSpaceImpl implements FlowSpace {

    public static FlowSpaceImpl getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {

        private static final FlowSpaceImpl INSTANCE = new FlowSpaceImpl();
    }

    private FlowSpaceImpl() {
    }
}