@Controller
public class MyController {

    @Autowired
    protected MyService myService;

    //This method will be executed when an exception of type SomeException1 is thrown
    //by one of the controller methods
    @ExceptionHandler(SomeException1.class)
    public String handleSomeException1(...) {
        //...
        //do some stuff
        //...

        return "view-saying-some-exception-1-occured";
    }

    //This method will be executed when an exception of type SomeException2 is thrown
    //by one of the controller methods
    @ExceptionHandler(SomeException2.class)
    public String handleSomeException2(...) {
        //...
        //do some stuff
        //...

        return "view-saying-some-exception-2-occured";
    }


    //The controller method that will entertain request mappings must declare 
    //that they can throw the exception class that your exception handler catches
    @RequestMapping(value = "/someUrl.htm", method = RequestMethod.POST)
    public String someMethod(...) throws SomeException1, SomeException2{

        //...
        //do some stuff, call to myService maybe
        //...

        return "the-happy-path-view-name";
    }
}