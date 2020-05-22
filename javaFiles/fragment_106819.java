@Bean
public MyCommonInterfaceImplementation getMyCommonInterfaceImplementation(){
    return MyBeanFactory.createInstance(MyCommonInterfaceImplementation.class);
}

//should autowire here
@Autowired
private MyCommonInterfaceImplementation impl;