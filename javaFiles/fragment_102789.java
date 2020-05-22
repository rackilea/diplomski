<event type="org.jboss.seam.security.notLoggedIn">
      <action execute="#{redirect.captureCurrentView}"/>
      <action execute="#{identity.tryLogin}"/> 
    </event>
    <event type="org.jboss.seam.security.loginSuccessful">
        <action execute="#{redirect.returnToCapturedView}"/>
     </event>