@Component
public class FooComponent {
    @Autowired
    Service service;
    public void foo() {
        System.out.println(service.getId()); //prints the value injected by Spring
    }
}