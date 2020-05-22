@Configuration
public class MyBeans {

  @Bean
  public Date periodBeginTimestamp() {
    return new Date();
  }

  @Bean
  public List<UserStats> agents() {
    return new ArrayList<UserStats>();
  }

  @Bean
  public PeriodUnit periodUnit() {
    return new PeriodUnit();
  }

}