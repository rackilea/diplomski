class BigClass {

    List<Foo> foos = new LinkedList<Foo>();

    public Iterable<Boo> allBoos() {
        return Iterables.concat(this.foos);
    }
}

class Boo {
    final int a;

    Boo(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return String.valueOf(this.a);
    }
}

class Foo
    implements Iterable<Boo> {

    List<Boo> boos = new LinkedList<Boo>();

    @Override
    public Iterator<Boo> iterator() {
        return this.boos.iterator();
    }
}

public class Sample {
    public static void main(String[] args) {

        Boo b1 = new Boo(1);
        Boo b3 = new Boo(3);
        Boo b5 = new Boo(5);

        Boo b2 = new Boo(2);
        Boo b4 = new Boo(4);
        Boo b6 = new Boo(6);

        Foo odd = new Foo();
        odd.boos.addAll(Arrays.asList(b1, b3, b5));

        Foo even = new Foo();
        even.boos.addAll(Arrays.asList(b2, b4, b6));

        BigClass b = new BigClass();
        b.foos.add(odd);
        b.foos.add(even);

        System.out.println(b.allBoos()); // [1, 3, 5, 2, 4, 6]
    }
}