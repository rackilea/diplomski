<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"
        destroy-method="close">
        <property name="driverClass" value="${datasource.mysql.driverClassName}" />
        <property name="jdbcUrl" value="${datasource.mysql.url}" />
        <property name="user" value="${datasource.mysql.username}" />
        <property name="password" value="${datasource.mysql.password}" />
        <property name="maxIdleTime" value="${datasource.mysql.maxIdle}" />
    </bean>

     <bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="packagesToScan" value="com.edgeowt.entities"/>
        <property name="hibernateProperties">
            <props>
                <prop key="show_sql">${hibernate.show_sql}</prop>
                  <prop key="hibernate.dialect">${hibernate.dialect}</prop>
            </props>
        </property>
    </bean>

    <bean id="transactionManager" class="org.springframework.orm.hibernate4.HibernateTransactionManager">
        <property name="sessionFactory" ref="sessionFactory" />
    </bean>