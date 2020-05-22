applicationContext.getBean("beanName", new Object[]{arg1, arg2, arg3});

<bean id="beanName" class="my.package.className" scope="prototype">
  <constructor-arg index="0" type="java.lang.String" value=""/>
  //etc
</bean>