<bean id="clientDataSource" class="com.zaxxer.hikari.HikariDataSource" destroy-method="close">
    <property name="driverClassName" value="${driver.className}"/>
    <property name="jdbcUrl" value="${db.url}"/>
    <property name="username" value="${db.username}"/>
    <property name="password" value="${db.password}"/>
    <property name="maximumPoolSize" value="30" />
    <property name="connectionTestQuery" value="SELECT 1" />
</bean>

<bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
    <property name="dataSource" ref="clientDataSource"/>
    <property name="packagesToScan"  value = "org.brightworks.genesis.commons.model"/>
    <property name="jpaVendorAdapter">
        <bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter">
            <property name="databasePlatform" value="${hibernate.sql.dialect}" />
            <property name="showSql" value="true" />
        </bean>
    </property>
    <property name="jpaProperties">
        <props>
            <prop key="hibernate.format_sql">true</prop>
            <prop key="hibernate.multiTenancy">SCHEMA</prop>
            <prop key="hibernate.tenant_identifier_resolver">com.myprojec.SchemaResolver</prop>
            <prop key="hibernate.multi_tenant_connection_provider">com.myproj.hibernate.MultitenantConnectionProvider</prop>
        </props>
    </property>
</bean>