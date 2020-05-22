@Component
@ConfigurationProperties(prefix="tenantdb", locations={"datasources.yml"})
public class TenantDbProperties {

  //DataSourceConfig is POJO with key, dbpath and dbname
  private List<DataSourceConfig> dataSourceConfigs;       

  public List<DataSourceConfig> getDataSourceConfigs(){
      return dataSourceConfigs;
  }

  public void setDataSourceConfigs(List<DataSourceConfig> dataSourceConfigs){
      this.dataSourceConfigs = dataSourceConfigs;
  }
}