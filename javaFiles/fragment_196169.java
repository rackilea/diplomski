public interface IStatisticsMBean {
  void printStatistics();
  ....
}

@Management(IStatisticsMBean.class)
@Service(objectName = Statistics.ManagementJNDIName)
@Depends({Statistics.MSEJNDIName})
public class StatisticsImplMBean {
....
}