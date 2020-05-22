public interface Updatable<This> {
    void updateData(This t);
}

// any Foo implementing Updatable must supply This=Foo

public class Office implements Updatable<Office>