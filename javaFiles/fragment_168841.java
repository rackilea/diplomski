<amq:connectionFactory id="jmsConnectionFactory" brokerURL="${jms.host}">
    <amq:redeliveryPolicy>
      <amq:redeliveryPolicy maximumRedeliveries="0" />
    </amq:redeliveryPolicy>
  </amq:connectionFactory>

  <bean id="cachingJmsConnectionFactory" class="org.springframework.jms.connection.CachingConnectionFactory">
    <property name="targetConnectionFactory" ref="jmsConnectionFactory" />
  </bean>

  <jms:annotation-driven />

  <bean id="jmsListenerContainerFactory" class="org.springframework.jms.config.DefaultJmsListenerContainerFactory">
    <property name="connectionFactory" ref="cachingJmsConnectionFactory" />
  </bean>