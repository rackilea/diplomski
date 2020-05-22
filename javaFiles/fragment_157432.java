<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
    destroy-method="close">
    <property name="driverClassName" value="${database.driver}" />
    <property name="url" value="${database.url}" />
    <property name="username" value="${database.username}" />
    <property name="password" value="${database.password}" />
    <property name="timeBetweenEvictionRunsMillis" value="300000" />
    <property name="numTestsPerEvictionRun" value="6" />
    <property name="minEvictableIdleTimeMillis" value="1800000" />
    <property name="initialSize" value="3" />
    <property name="maxActive" value="10" />
    <property name="maxIdle" value="10" />
    <property name="maxWait" value="5000" />
    <property name="poolPreparedStatements" value="true" />
    <property name="maxOpenPreparedStatements" value="100" />
</bean>