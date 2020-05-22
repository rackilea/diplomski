<bean name="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
    <property name="driverClassName" value="${database.driver.classname}"/>
    <property name="url" value="${database.url}"/>
    <property name="username" value="${database.username}"/>
    <property name="password" value="${database.password}"/>
    <property name="initialSize" value="2"/>
    <property name="maxActive" value="50"/>
    <property name="maxIdle" value="5"/>
    <property name="maxWait" value="-1"/>
    <property name="removeAbandoned" value="true"/>
    <property name="removeAbandonedTimeout" value="600"/>
    <property name="logAbandoned" value="true"/>
    <property name="testOnBorrow" value="true" />
    <property name="validationQuery" value="SELECT 1" />        
</bean>