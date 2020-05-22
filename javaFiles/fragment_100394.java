@RestController
class SomeController {

    @Autowired
    SomeServiceFactory someServiceFactory;


    public void someEndpoint() {
     SomeService someService1 = SomeServiceFactory.getSomeServiceByName("someService1"); //You need to decide what argument to pass based on condition
     someService1.someFunction(...); // this will have url1 and password1
   } 
}