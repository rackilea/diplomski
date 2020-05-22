<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns:mvc="http://www.springframework.org/schema/mvc"
    xmlns:context="http://www.springframework.org/schema/context"
xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
    http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd">


...

  <!-- Configures Handler Interceptors -->
  <mvc:interceptors>
    <!-- Changes the locale when a 'locale' request parameter is sent; e.g. 
    /?locale=de -->
    <bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor" />
  </mvc:interceptors>
  <bean id="localeResolver" class="org.springframework.web.servlet.i18n.CookieLocaleResolver">
    <property name="cookieName" value="myCookie" />
    <property name="defaultLocale" value="de" />
  </bean>
....
</beans>