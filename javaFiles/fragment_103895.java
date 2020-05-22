@Autowire
private MyService communicator;

//...

@Service
@Profile("prd")
class MyServiceImpl //...

@Service
@Profile("qa")
class MyServiceStub //...