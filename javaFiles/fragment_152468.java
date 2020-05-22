=========================
AUTO-CONFIGURATION REPORT
=========================


Positive matches:
-----------------

   AopAutoConfiguration
      - @ConditionalOnClass classes found: org.springframework.context.annotation.EnableAspectJAutoProxy,org.aspectj.lang.annotation.Aspect,org.aspectj.lang.reflect.Advice (OnClassCondition)
      - matched (OnPropertyCondition)

   AopAutoConfiguration.JdkDynamicAutoProxyConfiguration
      - matched (OnPropertyCondition)

   AuditAutoConfiguration#authenticationAuditListener
      - @ConditionalOnClass classes found: org.springframework.security.authentication.event.AbstractAuthenticationEvent (OnClassCondition)

   AuditAutoConfiguration#authorizationAuditListener
      - @ConditionalOnClass classes found: org.springframework.security.access.event.AbstractAuthorizationEvent (OnClassCondition)

   AuditAutoConfiguration.AuditEventRepositoryConfiguration
      - @ConditionalOnMissingBean (types: org.springframework.boot.actuate.audit.AuditEventRepository; SearchStrategy: all) found no beans (OnBeanCondition)

[...]

Negative matches:
-----------------

   ActiveMQAutoConfiguration
      - required @ConditionalOnClass classes not found: javax.jms.ConnectionFactory,org.apache.activemq.ActiveMQConnectionFactory (OnClassCondition)

   AopAutoConfiguration.CglibAutoProxyConfiguration
      - @ConditionalOnProperty missing required properties spring.aop.proxy-target-class  (OnPropertyCondition)

   AtomikosJtaConfiguration
      - required @ConditionalOnClass classes not found: com.atomikos.icatch.jta.UserTransactionManager (OnClassCondition)