<bean id="thisDatasource"
class="org.springframework.jdbc.datasource.DriverManagerDataSource"
p:driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver"
p:url="jdbc:sqlserver://sqlserver:1234;databaseName=myTables"
p:username="userid"
p:password="passw0rd" /> 


<bean id="databaseUserDAOTest" 
class="com.spring.security.custom.user.detail.DatabaseUserDAO" >
<!-- Inject the datasource of the jdbcTemplate -->
<property name="dataSource" ref="thisDatasource" />        
</bean>