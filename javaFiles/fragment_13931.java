public class ServiceImpl implements Service {
    Service defaultService = new DefaultService();
    ThirdPartyService thirdPartyService = new ThirdPartyService();

    @Override
    public Object compute1() {
        return run(thirdPartyService::customCompute1, defaultService::compute1);
    }

    @Override
    public Object compute2() {
        return run(thirdPartyService::customCompute2, defaultService::compute2);
    }

    private static <T> T run(Supplier<T> action, Supplier<T> fallback) {
        try {
            T result = action.get();
            return result != null ? result : fallback.get();
        } catch(Exception e) {
            return fallback.get();
        }
    }
}