@Autowired(required=false)
private MyServiceToInject myService;

@Bean
public Mybean create() {
    bean = Mybean();
    if (myservice != null)
       bean.setMyservice(myService);
}