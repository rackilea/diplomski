<!-- DATASOURCE used for object stores -->
<bean id="dataSourceForObjects" class="org.apache.commons.dbcp.BasicDataSource"
    destroy-method="close">
    <property name="driverClassName" value="com.${job.repository.db.type}.jdbc.Driver" />
    <property name="url" value="jdbc:${job.repository.db.type}://${db.host}:${job.repository.db.port}/${db.schema}" />
    <property name="username" value="${db.user}" />  <!-- your user id. e.g. root-->
    <property name="password" value="${db.password}" /> <!-- your password-->
    <property name="maxIdle" value="10" />
    <property name="maxActive" value="100" />
    <property name="maxWait" value="10000" />
    <property name="validationQuery" value="select 1" />
    <property name="testOnBorrow" value="false" />
    <property name="testWhileIdle" value="true" />
    <property name="timeBetweenEvictionRunsMillis" value="1200000" />
    <property name="minEvictableIdleTimeMillis" value="1800000" />
    <property name="numTestsPerEvictionRun" value="5" />
    <property name="defaultAutoCommit" value="true" />
</bean>
    <bean id="objectStoreDao" class="com.pursway.core.dao.objectStore.ObjectStoreJdbcImpl">
    <property name="dataSource" ref="dataSourceForObjects"/>
</bean>