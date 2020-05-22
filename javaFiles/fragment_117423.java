<bean id="task" class="com.test.Task">
        <property name="taskName" value="${task.name}"/>
        <property name="counters">
        <list>
            <bean class="com.test.Counter" factoryMethod="createFor">
                 <constructor-arg ref="${counter.descriptor1}"/>
            </bean>
            <bean class="com.test.Counter" factoryMethod="createFor">
                 <constructor-arg ref="${counter.descriptor2}"/>
            </bean>
        </list>
</bean>