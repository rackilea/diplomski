<bean id="myDataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource" autowire="no">
    <property name="url" value="${jdbc.url}"/>
    <property name="username" value="${jdbc.username}"/>
    <property name="password" value="${jdbc.password}"/>
    <property name="connectionProperties">
        <props>
            <prop key="oracle.net.READ_TIMEOUT">60000</prop>
        </props>
    </property>
</bean>