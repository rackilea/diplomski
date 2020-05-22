<bean id="dataSource"
    class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close"
    p:driverClass="${jdbc.driverClassName}"
    p:jdbcUrl="${jdbc.url}"
    p:user="${jdbc.username}"
    p:password="${jdbc.password}" />