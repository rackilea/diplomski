public abstract class Wrap<T extends X>{

    protected T instance;

    public Wrap(T x){
        this.instance = x;
    }

    public void foo(){
       instance.foo();
    }
}



public final class WrapY extends Wrap<Y> {

    public WrapY(Y y) {
        super(y);
    }

    public void bar(){
        instance.bar();
    }
}