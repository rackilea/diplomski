public class CustomConnectionProvider extends InjectedDataSourceConnectionProvider {
    @Override
    public void configure(Properties props) throws HibernateException {
        org.apache.commons.dbcp.BasicDataSource dataSource = new BasicDataSource();
        org.apache.commons.beanutils.BeanUtils.populate( dataSource, props );
        setDataSource(dataSource);

        super.configure(props);
    }
}