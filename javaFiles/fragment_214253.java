<bean id="requestConfigBuilder" class="org.apache.http.client.config.RequestConfig"
    factory-method="custom">
    <property name="socketTimeout" value="${socketTimeoutInMillis}" /> 
    <property name="connectTimeout" value="${connectionTimeoutInMillis}" /> 
</bean>

<bean id="requestConfig" factory-bean="requestConfigBuilder" factory-method="build" />

<bean id="httpClientBuilder" class="org.apache.http.impl.client.HttpClientBuilder"
    factory-method="create">
    <property name="defaultRequestConfig" ref="requestConfig" />
</bean>

<bean id="httpClient" factory-bean="httpClientBuilder" factory-method="build" />