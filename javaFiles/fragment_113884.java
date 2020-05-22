@Component
public class PeriodContainer {

  private Date periodBeginTimestamp;
  private List<UserStats> agentsWithStatistics;
  private PeriodUnit periodUnit;

  public PeriodContainer(){}

  public void setValues(Date periodBeginTimestamp, List<UserStats> agents, PeriodUnit periodUnit){
    this.periodBeginTimestamp = periodBeginTimestamp;
    this.agentsWithStatistics = agents;
    this.periodUnit = periodUnit;
  }

  ...
}