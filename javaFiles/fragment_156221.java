@Configuration
@MapperScan(value = { "...mapper.mybatis.db2" }, sqlSessionFactoryRef = "db2SqlSessionFactory")
public class Db2Context {

  @Primary
  @Bean(name = "db2DataSource")
  public DataSource getDataSource() { ...

  @Primary
  @Bean(name = "db2SqlSessionFactory")
  public SqlSessionFactory getSqlSessionFactory() {...

@Configuration
@MapperScan(value = { "...mapper.mybatis.other" }, sqlSessionFactoryRef = "otherSqlSessionFactory")
public class OtherContext {

  @Bean(name = "otherDataSource")
  public DataSource getDataSource() { ...

  @Bean(name = "otherSqlSessionFactory")
  public SqlSessionFactory getSqlSessionFactory() {...