@Component
public class B {
    @Autowired
    public B(A a,
             @Value("${some.property.1}") String name1,
             @Value("${some.property.2}") String name2,
             @Value("${some.property.3}") boolean b1) {
        ...
    }
}