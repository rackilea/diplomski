public interface MyService {
    public String foobar(int baz);
}

public static class CommonBehavior {
    // whatever is used by Superclass and Subclass
}

@Component @Lazy
public class FormerSuperClass implements MyService {
   private final CommonBehavior ...;
   ...
}

@Component @Lazy
public class FormerSubClass implements MyService {
   private final CommonBehavior ...;
   ...
}