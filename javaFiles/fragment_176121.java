public class Test {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a);
    }
}

class A {
    int i = 5;
    B obj = new B();
    String str = "hello";
    public String toString() {
        return String.format("A: [i: %d, obj: %s, str: %s]", i, obj, str);
    }
}

class B {
    int j = 17;
    public String toString() {
        return String.format("B: [j: %d]", j);
    }
}