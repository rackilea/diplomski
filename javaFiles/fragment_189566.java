@Singleton
public class SomeDAO {

  @Inject
  private DataSourceManager dataSourceManager;

  public doAction(String dataSourceId) {

    dataSourceManager.get(dataSourceId). //..
  }

}