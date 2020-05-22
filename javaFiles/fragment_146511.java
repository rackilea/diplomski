public interface Interface1 {
    void interfaceMethod1();
}

public class Class0 {

}
public class Class2 extends Class0 implements Interface1 {
    @Override
    public void interfaceMethod1() {

    }
}

public class Class1<T extends Class0 & Interface1> {
    private T field;

    public T getField() {
        return field;
    }
}