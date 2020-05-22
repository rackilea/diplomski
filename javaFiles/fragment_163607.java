<mvc:annotation-driven>
        <mvc:message-converters>
             <bean class="mypackage.CustomMappingJackson2HttpMessageConverter">
                 <property name="jsonPrefix" value=")]}'," />
             </bean>
         </mvc:message-converters>
    </mvc:annotation-driven>