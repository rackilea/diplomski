<bean id="passwordAuth" class="javax.mail.PasswordAuthentication">
        <constructor-arg>
            <value>${sender.email}</value>
        </constructor-arg>
        <constructor-arg>
            <value>${sender.password}</value>
        </constructor-arg>
    </bean>

<bean id="authenticator" class="javax.mail.Authenticator">
    <lookup-method name="getPasswordAuthentication" bean="passwordAuth" />
</bean>

<bean id="emailSession" class="javax.mail.Session">
    <constructor-arg>
        <props>
            <prop key="mail.smtp.auth">${mail.smtp.auth}</prop>
            <prop key="mail.smtp.starttls.enable">${mail.smtp.starttls.enable}</prop>
            <prop key="mail.smtp.host">${mail.smtp.host}</prop>
            <prop key="mail.smtp.socketFactory.port">${mail.smtp.port}</prop>
            <prop key="mail.smtp.socketFactory.class">${mail.smtp.socketFactory.class}</prop>
            <prop key="mail.smtp.port">${mail.smtp.port}</prop>
        </props>
    </constructor-arg>
    <constructor-arg ref="authenticator" />
</bean>