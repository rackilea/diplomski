public class WrapY<U extends Y> extends Wrap<U> {

    public WrapY(U y) {
        super(y);
    }

    public void bar(){
        instance.bar();
    }
}