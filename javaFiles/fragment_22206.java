@ComponentScan(
    basePackages = {"com.company.api"},
    excludeFilters={
         @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=com.company.common.jar1.Inteceptor1.class) ,
         @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=com.company.common.jar2.Inteceptor1.class)
    })