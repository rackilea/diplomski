<mvc:annotation-driven content-negotiation-manager="contentManager">
            <mvc:message-converters>
                <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
                    <property name="jsonPrefix" value=")]}',\n" />
                </bean>
            </mvc:message-converters>
        </mvc:annotation-driven>