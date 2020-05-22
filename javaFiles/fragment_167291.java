@Component
 public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
       int errorCode = check(); // perform some specific health check
       if (errorCode != 0) {
         return Health.down().withDetail("Error Code", errorCode).build();
       }
       return Health.up().build();
    }
 }