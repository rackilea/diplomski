<bean class="org.springframework.scheduling.quartz.SchedulerFactoryBean">
    <property name="triggers">
        <bean class="com.yourcompany.FactoryBeanThatReturnsAListOfTriggers">
            <property name="triggerNames" value="${some.property}" />
        </bean>

    </property>
</bean>

<context:property-placeholder location="classpath:your.properties" />