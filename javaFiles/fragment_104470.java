public class CircuitBreakerHystrixEventNotifier extends HystrixEventNotifier{

    public CircuitBreakerHystrixEventNotifier(){

    }

   public void markEvent(HystrixEventType eventType, HystrixCommandKey key) {
        //here write code based on eventTypes.
    }
}