@Test
    public void trans_management_test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("databaseconf/transaction-conf.xml");

        CustomerManager customerTransactionImp = context.getBean("manager", CustomerManager.class);
        customerTransactionImp.operation("Administration", 110);
    }

@Component("trans")
public class CustomerTransactionImp extends JdbcDaoSupport{

    public static final Logger logger = Logger.getLogger(CustomerTransactionImp.class.getName());

    @Autowired
    public CustomerTransactionImp(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Transactional
    public void deleteCustomerByName(String name){
        String sql = "DELETE FROM departments WHERE department_name = ?";

        logger.info("Deleted customer named: "+ name);
        getJdbcTemplate().update(sql,name);
    }

    @Transactional
    public void deleteCustomerByID(Long ID) {
        String sql = "DELETE FROM departments WHERE department_id = ?";

        logger.info("Deleted customer named: "+ ID);
        getJdbcTemplate().update(sql, ID);
    }

@Component("manager")
public class CustomerManager {

    @Autowired
    CustomerTransactionImp transactionImp;

    @Transactional
    public void operation(String name , long ID){
        transactionImp.deleteCustomerByID(ID);
        transactionImp.deleteCustomerByName(name);
    }

    public CustomerTransactionImp getTransactionImp() {
        return transactionImp;
    }

 <context:annotation-config></context:annotation-config>
    <context:component-scan base-package="database.transactionmanagement"/>

    <bean id="datasource2" class="org.apache.tomcat.dbcp.dbcp2.BasicDataSource" destroy-method="close">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost/hr"/>
        <property name="username" value="root"/>
        <property name="password" value=""/>
    </bean>

    <tx:annotation-driven transaction-manager="transactionManager"/>

    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <constructor-arg name="dataSource" ref="datasource2"/>
    </bean>