public class MyClass implements A, B {

    @Override
    public void mymethod(){
        System.out.println("hello world");
    }

}
...

public interface A {
    void mymethod();
}
...

public interface B {
    String mymethod();
}