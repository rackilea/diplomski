<bean class="org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver"
      id="vmViewResolver" p:order="10" p:suffix=".vm" p:prefix=""
      p:cache="true" p:contentType="text/html;charset=UTF-8"
      p:exposeRequestAttributes="false" p:exposeSessionAttributes="false"
      p:exposePathVariables="true" p:exposeSpringMacroHelpers="true"
      p:dateToolAttribute="date" p:toolboxConfigLocation="/WEB-INF/toolbox.xml"
      p:viewClass="i2.application.commun.web.views.Velocity2LayoutView">
...