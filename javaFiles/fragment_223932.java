<beans:bean id="myApiConfig" class="org.scribe.model.OAuthConfig">
    <beans:constructor-arg value="${key.access}"/>
    <beans:constructor-arg value="${key.secret}"/>
    <beans:constructor-arg value="${url.callback}"/>
    <beans:constructor-arg type="org.scribe.model.SignatureType" value="QueryString"/>
    <beans:constructor-arg value="some-permission"/>
    <beans:constructor-arg><beans:null /></beans:constructor-arg>
</beans:bean>

<beans:bean id="myApi" class="com.chartminder.app.MyApi">
</beans:bean>

<beans:bean class="org.scribe.oauth.OAuth10aServiceImpl">
    <beans:constructor-arg ref="myApiConfig"/>
    <beans:constructor-arg ref="myApi"/>
</beans:bean>