public class ServiceAProxy implements ServiceA {
    private final ServiceA serviceA;
    private final RateLimiter throttle;

    public ServiceAProxy(ServiceA serviceA, double callsPerSecond) {
        this.serviceA = serviceA;
        throttle = RateLimiter.create(callsPerSecond);
    }

    public Result call(String parameter) {
        // every thread may potentially block here until throttle allows it to proceed 
        throttle.acquire();
        return serviceA.call(parameter);
    }
}