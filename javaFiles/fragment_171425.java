<bean id="userSearch"
        class="org.springframework.security.ldap.search.FilterBasedLdapUserSearch">
    <constructor-arg index="0" value="${my.ldap.base}"/>
    <constructor-arg index="1" value="${my.ldap.filter}"/>
    <constructor-arg index="2" ref="contextSource"/>
  </bean>

  <bean id="ldapAuthoritiesPopulator" class="org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator">
    <constructor-arg ref="contextSource"/>
      <constructor-arg value="${my.ldap.usersearch.base}"/>
      <property name="groupSearchFilter" value="${my.group.filter}" />
      <property name="groupRoleAttribute" value="${my.group.attribute}" />
    <property name="searchSubtree" value="true" />
  </bean>

  <bean id="ldapUserDetailsService" class="org.springframework.security.ldap.userdetails.LdapUserDetailsService">
    <constructor-arg ref="userSearch"/>
    <constructor-arg ref="ldapAuthoritiesPopulator"/>
  </bean>