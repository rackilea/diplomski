09:55:10,036 INFO  [io.undertow.servlet] (ServerService Thread Pool -- 69) 1 Spring WebApplicationInitializers detected on classpath
09:55:10,105 INFO  [javax.enterprise.resource.webcontainer.jsf.config] (ServerService Thread Pool -- 69) Initializing Mojarra 2.2.13.SP1 20160303-1204 for context '/SpringTest-0.0.1-SNAPSHOT'
09:55:10,808 INFO  [io.undertow.servlet] (ServerService Thread Pool -- 69) Initializing Spring root WebApplicationContext
09:55:10,809 INFO  [org.springframework.web.context.ContextLoader] (ServerService Thread Pool -- 69) Root WebApplicationContext: initialization started
09:55:10,818 INFO  [org.springframework.web.context.support.AnnotationConfigWebApplicationContext] (ServerService Thread Pool -- 69) Refreshing Root WebApplicationContext: startup date [Fri Apr 14 09:55:10 EDT 2017]; root of context hierarchy
09:55:10,852 INFO  [org.springframework.web.context.support.AnnotationConfigWebApplicationContext] (ServerService Thread Pool -- 69) Registering annotated classes: [class com.clomez.config.RootConfig]
09:55:10,962 INFO  [org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor] (ServerService Thread Pool -- 69) JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
09:55:11,018 INFO  [org.springframework.web.context.ContextLoader] (ServerService Thread Pool -- 69) Root WebApplicationContext: initialization completed in 209 ms
09:55:11,027 INFO  [io.undertow.servlet] (ServerService Thread Pool -- 69) Initializing Spring FrameworkServlet 'dispatcher'
09:55:11,027 INFO  [org.springframework.web.servlet.DispatcherServlet] (ServerService Thread Pool -- 69) FrameworkServlet 'dispatcher': initialization started
09:55:11,030 INFO  [org.springframework.web.context.support.AnnotationConfigWebApplicationContext] (ServerService Thread Pool -- 69) Refreshing WebApplicationContext for namespace 'dispatcher-servlet': startup date [Fri Apr 14 09:55:11 EDT 2017]; parent: Root WebApplicationContext
09:55:11,030 INFO  [org.springframework.web.context.support.AnnotationConfigWebApplicationContext] (ServerService Thread Pool -- 69) Registering annotated classes: [class com.clomez.config.WebConfig]
09:55:11,116 INFO  [org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor] (ServerService Thread Pool -- 69) JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
09:55:11,270 INFO  [org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping] (ServerService Thread Pool -- 69) Mapped "{[/]}" onto public java.lang.String com.clomez.controller.HomeController.home()
09:55:11,481 INFO  [org.hibernate.validator.internal.util.Version] (ServerService Thread Pool -- 69) HV000001: Hibernate Validator 5.2.4.Final
09:55:11,539 INFO  [org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter] (ServerService Thread Pool -- 69) Looking for @ControllerAdvice: WebApplicationContext for namespace 'dispatcher-servlet': startup date [Fri Apr 14 09:55:11 EDT 2017]; parent: Root WebApplicationContext
09:55:11,615 INFO  [org.springframework.web.servlet.DispatcherServlet] (ServerService Thread Pool -- 69) FrameworkServlet 'dispatcher': initialization completed in 588 ms
09:55:11,616 INFO  [org.wildfly.extension.undertow] (ServerService Thread Pool -- 69) WFLYUT0021: Registered web context: /SpringTest-0.0.1-SNAPSHOT
09:55:11,635 INFO  [org.jboss.as.server] (ServerService Thread Pool -- 34) WFLYSRV0010: Deployed "SpringTest-0.0.1-SNAPSHOT.war" (runtime-name : "SpringTest-0.0.1-SNAPSHOT.war")