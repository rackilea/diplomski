@Configuration
@ComponentScan
public class StackOverflow {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(StackOverflow.class);
        System.out.println(ctx.getBean(Composite.class).list);
    }
}

interface Abstraction {
    void execute();
}

@Named
class Composite implements Abstraction {
    List<Abstraction> list;

    @Inject
    public Composite(List<Abstraction> list) {
        this.list = list;
    }

    public void execute() {
        list.forEach(Abstraction::execute);
    }
}

@Named
class Implementation1 implements Abstraction {
    public void execute() {
    }
}

@Named
class Implementation2 implements Abstraction {
    public void execute() {
    }
}