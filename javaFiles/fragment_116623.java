<bean id="ldapContextSource"
      class="org.springframework.ldap.core.support.LdapContextSource"
      p:url="${ldap.server.url}">
    <property name="baseEnvironmentProperties">
        <map>
            <entry key="java.naming.ldap.derefAliases" value="never"/>
        </map>
    </property>
</bean>