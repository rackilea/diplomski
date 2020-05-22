<bean id="propertySourcesPlaceholderConfigurer"
 class="org.springframework.context.support.PropertySourcesPlaceholderConfigurer">
    <property name="locations">
        <list>
            <value>${config.dir}/other.properties</value>
        </list>
    </property>
</bean>