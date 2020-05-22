<bean id="resource">
    <property name="size">
        <bean class="java.lang.Integer" factory-method="decode">
            <constructor-arg value="${app.size}" type="java.lang.String" />
        </bean>
    </property>
</bean>