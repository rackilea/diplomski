public class SimpleClass {

    private String parameter;

    @JsonIgnore
    @Autowired
    private SomeService service;

    // getter and setter for parameter (omitted here for brevity)

    public void doSomethingFromService(){
        //call some methods from the service
    }
}