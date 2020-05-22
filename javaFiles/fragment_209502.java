<bean name="myBean" class="com.company.MyClass">
  <constructor-arg>
    <bean class="org.springframework.util.StringUtils" factory-method="commaDelimitedListToSet">
        <constructor-arg type="java.lang.String" value="${the.value}"/>
    </bean>
  </constructor-arg>
</bean>