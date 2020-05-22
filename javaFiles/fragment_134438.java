<bean id="retryAdvice" class="org.springframework.retry.interceptor.RetryOperationsInterceptor">
    <property name="retryOperations">
        <bean class="org.springframework.retry.support.RetryTemplate">
            <property name="retryPolicy">
                <bean class="org.springframework.retry.policy.SimpleRetryPolicy">
                    <property name="maxAttempts" value="${max.attempts}" />
                </bean>
            </property>
            <property name="backOffPolicy">
                <bean class="org.springframework.retry.backoff.ExponentialBackOffPolicy">
                    <property name="initialInterval" value="${delay}" />
                    <property name="multiplier" value="${multiplier}" />
                </bean>
            </property>
        </bean>
    </property>
</bean>

<aop:config>
    <aop:pointcut id="retries"
        expression="execution(* org..EchoService.test(..))" />
    <aop:advisor pointcut-ref="retries" advice-ref="retryAdvice"
        order="-1" />
</aop:config>