public class B extends A {
    int innerData;
    public B() {
        super((data1, type) -> innerData = 1);
    }
}