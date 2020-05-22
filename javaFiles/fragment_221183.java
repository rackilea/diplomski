<!-- datasource-test.xml -->
<bean id="domainDataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close">
   <property name="driverClass" value="${db.driver}" />
   <property name="jdbcUrl" value="${datasource.url}" />
   <property name="user" value="${datasource.username}" />
   <property name="password" value="${datasource.password}" />
   <property name="initialPoolSize" value="5"/>
   <property name="minPoolSize" value="5"/>
.....
</bean>