public class TestAspect {

    @LogPerformance
    public void thisMethodNeedsToBeMonitored(){
        // Do Something
    }
    public void thisMethodNeedsToBeMonitoredToo(){
        // Do Something
    } 
}

@interface LogPerformance{}

@Aspect
class PerformanceAspect{
    @Around("the pointcut expression to pick up all " +
            "the @PerfMonitor annotated methods")
    public void logPerformance(){
        // log performance here
        // Log it to a file
    }
}