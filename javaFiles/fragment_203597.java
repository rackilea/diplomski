public interface Visitor {
    public void visit(ConfigA config);
    public void visit(ConfigB config);
}

@Component
public class ConcreteVisitor implements Visitor {

    @Override
    public void visit(ConfigA config) {
        // Do something
    }

    @Override
    public void visit(ConfigB config) {
        // Do something
    }
}

@Autowired
private Visitor visitor;