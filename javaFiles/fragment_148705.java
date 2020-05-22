import java.util.Iterator;
import java.util.NoSuchElementException;

public class Foo implements Iterable<Foo> {
    private final int value;

    public Foo(final int value) {
        this.value = value;
    }


    @Override
    public Iterator<Foo> iterator() {
        return new Iterator<Foo>() {
            private Foo foo = new Foo(0);

            @Override
            public boolean hasNext() {
                return foo.value < Foo.this.value;
            }

            @Override
            public Foo next() {
                if (!hasNext()) throw new NoSuchElementException();

                Foo cur = foo;
                foo = new Foo(cur.value+1);
                return cur;
            }
        };
    }

    public static void main(String[] args) {
        Foo foo = new Foo(10);
        for (Foo f: foo) {
            System.out.println(f.value);
        }
    }
}