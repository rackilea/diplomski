<bean id="sysProperties" class="org.springframework.beans.factory.config.MethodInvokingFactoryBean">
       <property name="targetObject" value="#{@systemProperties}"/>
       <property name="targetMethod" value="putAll"/>
       <property name="arguments">
           <util:properties>
               <prop key="propertyname_used_in_ecache_xml">#{proerties_defined_using_property_factory['propertyname_defined_in_external_properties_file']}</prop>
           </util:properties>
       </property>
    </bean>

    <bean id="cacheManager"
        class="org.springframework.cache.ehcache.EhCacheManagerFactoryBean" depends-on="sysProperties">
        <property name="configLocation">
            <value>classpath:ehcache.xml</value>
        </property>
    </bean>