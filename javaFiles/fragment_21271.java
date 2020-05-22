public class MyLocalContainerEntityManagerFactoryBean extends LocalContainerEntityManagerFactoryBean {

public static final LoggerWrapper logger = new LoggerWrapper(MyLocalContainerEntityManagerFactoryBean.class);

@Override
public void destroy() {

    logger.warning("Destroying MyLocalContainerEntityManagerFactoryBean!");

    DataSource ds = getDataSource();
    if(ds instanceof HikariDataSource) {
        HikariDataSource hds = (HikariDataSource)ds;

        logger.warning("Closing the Hikari data source!");
        hds.close();
    }

    super.destroy();
}