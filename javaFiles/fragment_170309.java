public interface Foo {
    public static final int CONSTANT = 1;
}

public class NotOkay implements Foo {
    private int value = CONSTANT;
}

public class Okay {
    private int value = Foo.CONSTANT;
}