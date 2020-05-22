@Service
public class MyClass {
  @Autowire
  private PeriodContainer container;

  @PostConstruct
  private void init() {
    Date periodBeginTimestamp = getTimeStamp();
    List<UserStats> agents = getUserStatsList();
    PeriodUnit periodUnit = getPeriodUnit();
    container.setValues(periodBeginTimestamp, agents, periodUnit); 
  }
}