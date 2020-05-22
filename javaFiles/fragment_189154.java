// This seems a bit too contrived for my liking. Perhaps someone else will have a better idea.
public class Parent<T extends Parent<T>> {
    T foo () {
        return (T) this;
    }
}

public class Child extends Parent<Child> {
    public void bar () {
        Child c = foo();
    }
}