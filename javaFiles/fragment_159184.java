@Component
public class CircularClassA {

    private CircularClassB classB;

    @Autowired
    public CircularDependencyB(@Lazy CircularClassB classB) {
        this.classB = classB;
    }
}