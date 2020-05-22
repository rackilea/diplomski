public class DomesticDog extends Dog {
    private String name;

    public DomesticDog procreate(Dog anotherDog) {
        return (DomesticDog)super.procreate(anotherDog);
    }

    public Dog getSelf() {
        return new DomesticDog();
    }

    public String toString() {
        return super.toString() + " named " + name;
    }
}

public class Couple<T extends SelfMaker<? super T>> {
    protected T first;
    protected T second;

    public String toString() {
        return first.toString() + " and " + second.toString();
    }
}