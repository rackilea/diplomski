<bean id="loadPropertiesListener" class="PropertyLoaderJobExecutionListener" scope="step">
  <property name="pfb">
    <bean class="org.springframework.beans.factory.config.PropertiesFactoryBean">
      <property name="location" value="classpath:batch.#{jobParameters['region']}.properties" />
    </bean>
  </property>
</bean>