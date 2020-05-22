import java.util.Collection;
import java.util.ArrayList;

class Foo {
    public void blah() {
        Collection<? extends Foo> array = new ArrayList<Foo>();
        Collection<? extends Foo> badArray = new ArrayList<Object>();
    }
};