public class MyComponent {

    @Inject
    @MyFirstDatabase 
    SomeRepository someRepo;

    @Inject    
    @MySecondDatabase 
    SomeOtherRepository someOtherRepo;
}