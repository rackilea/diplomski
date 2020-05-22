//Spring CDI takes charge and autowires the Service and it's dependencies
@Autowired
private MyService myService;

public void someMethod(){
  setService(myService);
}