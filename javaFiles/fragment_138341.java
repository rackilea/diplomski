public abstract class Human {
    protected final Class taste;
    Human(Class taste) {
        this.taste = taste;
    }
    public boolean likes(Fruit fruit) {
        return fruit instanceof taste;
    } 
}

public class Boy extends Human {
    Boy(Class taste) {
        super(taste);
    }
}