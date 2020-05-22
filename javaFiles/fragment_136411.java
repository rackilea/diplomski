<!-- For database, uses maven filtering to fill in placeholders -->
<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
    <property name="driverClassName" value="${db.driver}" />
    <property name="url"             value="${db.url}" />
    <property name="username"        value="${db.username}" />
    <property name="password"        value="${db.password}" />
    <property name="maxActive">
        <value>10</value>
    </property>
    <property name="maxIdle">
        <value>1</value>
    </property>
</bean>