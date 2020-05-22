<bean class = "org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
    <property name="messageConverters">
        <array>
            <bean class = "org.springframework.http.converter.StringHttpMessageConverter">
                <property name="supportedMediaTypes" value = "text/plain;charset=UTF-8" />
            </bean>
        </array>
    </property>
</bean>