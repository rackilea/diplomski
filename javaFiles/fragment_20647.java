package p;

public class Super {

}

package p;

public class Sub extends Super {
    public String message;

    @Override
    public String toString() {
        return message;
    }
}