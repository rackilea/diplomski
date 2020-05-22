public interface AnimalVisitor {
    void visitDog(Dog d);
    void visitOther(Animal a);
}

public class Animal {
    public void accept(AnimalVisitor visitor) {
        visitor.acceptOther(this);
    }
}

public class Dog extends Animal {
    public void accept(AnimalVisitor visitor) {
        visitor.acceptDog(this);
    }
}

class Foo implements AnimalHelper {
    @Override
    helpAnAnimal(Animal a) { 
        a.accept(new AnimalVisitor() {
            public void visitDog(Dog d) {
                helpIt(d);
            }
            public void visitOther(Animal a) {
                helpIt(a);
            }
        });
    }

    private void helpIt(Dog d) {
    }

    private void helpIt(Animal a) {
    }
}