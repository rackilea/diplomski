import java.util.ArrayList;

class A {
}

class B extends A {
}

class Test {
    public static void main(String[] args) {
        ArrayList<A> arraylist = new ArrayList<A>();
        arraylist.add(new B());
    }
}