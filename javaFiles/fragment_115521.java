public interface IUsesExample {
    void doThing();
}

@Component
public class UsesExample implements IUsesExample {
    @Lookup
    protected Example getExample(String name) {return null;};

    public void doThing() {
        System.out.printf("%s.doThing(getExample() = %s)\n", this, getExample("aaa"));
        System.out.printf("%s.doThing(getExample() = %s)\n", this, getExample("bbb"));
    }
}