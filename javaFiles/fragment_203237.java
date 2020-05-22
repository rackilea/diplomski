package inheritance;

public abstract class AbstractEntity {

    public abstract AbstractEntity clone();
}


package inheritance;

public class ClassA extends AbstractEntity {

    @Override
    public ClassA clone() { return null; }

}


package inheritance;

public class Driver {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ClassA a = new ClassA();
        ClassA b = a.clone();
        System.out.println("all done");
    }

}