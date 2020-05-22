public class MyVoter extends RoleVoter {
  public int vote(Authentication authentication,
                java.lang.Object object,
                java.util.Collection<ConfigAttribute> attributes) {
    FilterInvocation filterInvocation = (FilterInvocation) object;
    HttpRequest request = filterInvocation.getHttpRequest();
    // get subdomain from request
    String subdomain = getSubdomain(request);
    if ("ogre".equals(subdomain)) {
      if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_OGRE_USER"))) {
         return ACCESS_GRANTED;
      } else {
         return ACCESS_DENIED;
      }
    }
    else {
      return super.vote(authentication, object, attributes);
    }
  }
}

<security:http auto-config="true" use-expressions="true" 
           access-decision-manager-ref="accessDecisionManager"

</security:http>

<bean id="accessDecisionManager"
  class="org.springframework.security.access.vote.UnanimousBased">
<property name="decisionVoters">
    <list>
        <bean class="MyVoter" />
    </list>
</property>