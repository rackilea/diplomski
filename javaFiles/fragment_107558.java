//Error creating the bean
Caused by: org.springframework.beans.factory.BeanCreationException: 
Error creating bean with name 'org.springframework.security.authentication.dao.DaoAuthenticationProvider#0': 
//The myUserDetailService reference cannot be solved, it cannot be found or it has syntax error or something is wrong there
Cannot resolve reference to bean 'myUserDetailService' while setting bean property 'userDetailsService'; 
//The root cause is an exception deeper.
nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: 
//You don't have a bean with this name:
No bean named 'myUserDetailService' is defined