@Component
public class BarComponent {
    @Autowired
    BeanFactory beanFactory;
    void bar() {
        Service service = (Service)beanFactory.get("service");
        System.out.println(service.getId()); //prints the value injected by Spring
    }
}