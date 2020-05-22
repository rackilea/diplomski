@Component
@Primary
public class ClassA {
    public void doSomething() {
        System.out.println("A");
    }
}

@Component
public class ClassB extends ClassA {
    @Override
    public void doSomething() {
        System.out.println("B");
    }
}

@Component
public class ClassC {
    @Autowired
    public ClassA component;
}