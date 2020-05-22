<property name="hibernateProperties">
        <props>
            <prop key="hibernate.dialect">${HIBERNATE.DIALECT}</prop>
            <prop key="hibernate.hbm2ddl.auto">${HBM2DDL_AUTO_UPDATE}</prop>
            <prop key="hibernate.show_sql">${SHOW_SQL_TRUE}</prop>
        </props>
    </property>
    <property name="cache.use_second_level_cache" value="true"></property>
    <property name="cache.provider_class" value="org.hibernate,cache.EhCacheProvider"></property>