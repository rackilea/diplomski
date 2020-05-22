public class ClassStart {
    ClassA a;

    public static void main(String[] args) {
       ClassStart s = new ClassStart();
    }

    public ClassStart() {
       a = new ClassA();  // create your ClassA instance
       ClassB b = new ClassB(a);  // pass it into your ClassB instance
       b.callAShowText();
    }
}