private void run() {
    List<Supplier<MyBaseClass>> factories = Arrays
            .asList(Impl1::new, Impl2::new, Impl3::new);
    List<MyBaseClass> baseClassInstances = factories.stream()
            .map(Supplier::get)
            .collect(Collectors.toList());
}

public abstract class MyBaseClass {
}

public class Impl1 extends MyBaseClass {
}

public class Impl2 extends MyBaseClass {
}

public class Impl3 extends MyBaseClass {
}