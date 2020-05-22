@Singleton
public class SomeDAO {

  @Inject
  private Provider<Map<String, SomeDataSource>> dataSourceProvider;

  public doAction(String dataSourceId) {

    dataSourceProvider.get().get(dataSourceId). //..
  }

}