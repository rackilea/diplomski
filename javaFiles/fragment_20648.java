package p;

public class Super {
    public String message;
}

package p;

public class Sub extends Super {
    @Override
    public String toString() {
        return message;
    }
}