<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
    <property name="driverClassName" value="${datasource.driverClassName}"/>
    <property name="url" value="${datasource.url}"/>
    <property name="username" value="${datasource.username}"/>
    <property name="password" value="${datasource.password}"/>
    <property name="connectionInitSqls" value="${datasource.connectionInitSqls}"/>
</bean>