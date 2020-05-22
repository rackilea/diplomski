<property name="hibernateProperties">
        <props>
            <prop key="hibernate.dialect">${HIBERNATE.DIALECT}</prop>
            <prop key="hibernate.hbm2ddl.auto">${HBM2DDL_AUTO_UPDATE}</prop>
            <prop key="hibernate.show_sql">${SHOW_SQL_TRUE}</prop>
            <prop key="hibernate.cache.use_second_level_cache">true</prop>
            <prop key="hibernate.cache.provider_class">org.hibernate.cache.EhCacheProvider</prop>
        </props>
    </property>