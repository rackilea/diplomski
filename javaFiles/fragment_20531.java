@Configuration
public class Cfg {

    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver);
        //...
        return ds;
    }

    @Bean
    public ClassA classA() {
        ClassA ca = new ClassA()
        ca.setDataSource(dataSource());
        return ca;
    }

    @Bean
    public ClassB classB() {
        ClassB cb = new ClassB()
        cb.setDataSource(dataSource());
        return cb;
    }

}