public abstract class A<T extends List<String>> {
    public abstract T method()
}

public class B extends A<ArrayList<String>> {
    public ArrayList<String> method() {
        //...
    }
}

public class C extends A<LinkedList<String>> {
    public LinkedList<String> method() {
        //...
    }
}