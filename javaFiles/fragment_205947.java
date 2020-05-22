public abstract class MyAbstractClass {

    public MyAbstractClass() {
        super();           // <== The Java compiler adds this call to Object's constructor (#3 in the list above)
        System.out.println("abstract default constructor");
    }

}
public class ConcreteClass extends MyAbstractClass{

    ConcreteClass() {      // <== The Java compiler adds this default constuctor (#1 in the list above)
        super();           // <== Which calls the superclass's (MyAbstractClass's) constructor (#2 in the list above)
    }

    public static void main(String[] args) {
        new ConcreteClass();
    }

}