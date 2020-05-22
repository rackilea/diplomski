<bean id="authy2FactorThreadBean" class="Authy2FactorThreadBean">
    <!-- twofactor.secret is the Secret shown by the Bitskins when you are authorizing your phone -->
    <property name="base32Secret" value="${twofactor.secret}"/>

    <!-- twofactor.key is the name of the key which can be displayed by the authenticator program -->
    <property name="keyId" value="${twofactor.key}"/>
</bean>